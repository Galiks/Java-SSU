package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientController clientController;

    @GetMapping("/newClient")
    public String newClientGet(Model model) {
        return clientController.clientInformation(model, new Client(), "newClient", "clients", false);
    }

    @PostMapping("/newClient/{clientID}/{returnUrl}")
    public String newClientPost(@ModelAttribute Client client, @PathVariable("clientID") String clientID, @PathVariable("returnUrl") String returnUrl) {
        clientRepository.save(client);
        return "redirect:/" + returnUrl;
    }
}
