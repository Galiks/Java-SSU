package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/registration")
    public String registrationGet(Model model) {
        model.addAttribute("client", new Client());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute Client client) {
        client = clientRepository.save(client);
        return "redirect:/home/" + client.getId();
    }
}
