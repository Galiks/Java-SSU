package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.dataTransferObject.ClientDto;
import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("client", new ClientDto());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute ClientDto clientDto) {
        Optional<Client> client = clientRepository.findByLogin(clientDto.getLogin());
        if (client.isPresent() && client.get().getPassword().equals(clientDto.getPassword())) {
            return "redirect:/home/" + client.get().getId();
        }
        return "redirect:/login";
    }
}
