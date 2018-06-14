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
public class EditClientController {

    @Autowired
    private ClientController clientController;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/editClient/{clientID}/{returnUrl}")
    public String editClientGet(Model model, @PathVariable("clientID") String clientID, @PathVariable("returnUrl") String returnUrl) {
        return clientController.clientInformation(model, clientRepository.findById(Long.valueOf(clientID)).get(), "editClient", returnUrl, false);
    }

    @PostMapping("/editClient/{clientID}/{returnUrl}")
    public String editClientPost(@ModelAttribute Client client, @PathVariable("clientID") String clientID, @PathVariable("returnUrl") String returnUrl) {
        client.setId(Long.valueOf(clientID));
        clientRepository.save(client);
        if (returnUrl.equals("home")) {
            returnUrl = returnUrl.concat("/" + clientID);
        }
        return "redirect:/" + returnUrl;
    }
}
