package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.dataTransferObject.ClientDto;
import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.repository.BankRepository;
import com.turchenkov.NewSpring.repository.ClientRepository;
import com.turchenkov.NewSpring.repository.OperationRepository;
import com.turchenkov.NewSpring.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OperationService operationService;

    public String clientInformation(Model model, Client client, String action, String returnUrl, boolean isShow) {
        model.addAttribute("client", client);
        model.addAttribute("clientID", client.getId());
        model.addAttribute("action", action);
        model.addAttribute("returnUrl", returnUrl);
        model.addAttribute("show", isShow);
        return "clientInfo";
    }

    @GetMapping("/home/{clientID}")
    public String homePage(Model model, @PathVariable("clientID") String clientID) {
        model.addAttribute("clientID", clientID);
        model.addAttribute("admin", clientRepository.findById(Long.valueOf(clientID)).get().isAdmin());
        return "home";
    }

    @GetMapping("/clients")
    public String clientsPageGet(Model model) {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        model.addAttribute("clients", clients);
        model.addAttribute("clientDto", new ClientDto());
        return "clients";
    }

    @PostMapping("/clients")
    public String clientsPagePost(@ModelAttribute ClientDto clientDto, @RequestParam(value = "action") String action) {
        if (clientDto.getClientID() == null) {
            return "redirect:/clients";
        }
        System.out.println(action);

        switch (action) {
            case "remove":
                clientRepository.deleteById(clientDto.getClientID());
                return "redirect:/clients";
            case "edit":
                return "redirect:/editClient/" + clientDto.getClientID() + "/clients";
            case "show":
            default:
                return "redirect:/showClient/" + clientDto.getClientID() + "/clients";
        }
    }

    @GetMapping("/showClient/{clientID}/{returnUrl}")
    public String showClientGet(Model model, @PathVariable("clientID") String clientID, @PathVariable("returnUrl") String returnUrl) {
        return clientInformation(model, clientRepository.findById(Long.valueOf(clientID)).get(), "showClient", returnUrl, true);
    }

    @PostMapping("/showClient/{clientID}/{returnUrl}")
    public String showClientPost(@ModelAttribute Client client, @PathVariable("clientID") String clientID, @PathVariable("returnUrl") String returnUrl) {
        if (returnUrl.equals("home")) {
            returnUrl = returnUrl.concat("/" + clientID);
        }
        return "redirect:/" + returnUrl;
    }
}
