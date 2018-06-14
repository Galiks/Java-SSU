package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.model.Bank;
import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.repository.BankRepository;
import com.turchenkov.NewSpring.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    @GetMapping("/client/{clientID}/accounts")
    public String accounts(Model model, @PathVariable("clientID") String clientID) {
        List<Bank> accounts;
        Boolean isAdmin = true;

        if ("all".equals(clientID)) {
            accounts = new ArrayList<>();
            bankRepository.findAll().forEach(accounts::add);
        } else {
            Client client = clientRepository.findById(Long.valueOf(clientID)).get();
            accounts = client.getAccount();
            isAdmin = false;
        }

        model.addAttribute("clientID", clientID);
        model.addAttribute("accounts", accounts);
        model.addAttribute("adminOrClient", isAdmin);
        return "accounts";
    }

    @GetMapping("/client/{clientID}/newAccount")
    public String newAccountGet(Model model, @PathVariable("clientID") String clientID) {
        model.addAttribute("client", clientRepository.findById(Long.valueOf(clientID)).get());
        model.addAttribute("account", new Bank());
        return "newAccount";
    }

    @PostMapping("/client/{clientID}/newAccount")
    public String newAccountPost(@ModelAttribute Bank bank, @PathVariable("clientID") String clientID) {
        Client client = clientRepository.findById(Long.valueOf(clientID)).get();
        bank.setClient(client);
        if (bank.getMoney() == 0) {
            bank.setMoney(0);
        }
        bankRepository.save(bank);
        return "redirect:/client/" + client.getId() + "/accounts";
    }
}
