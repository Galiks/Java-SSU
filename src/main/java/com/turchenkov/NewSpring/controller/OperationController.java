package com.turchenkov.NewSpring.controller;

import com.turchenkov.NewSpring.dataTransferObject.OperationDto;
import com.turchenkov.NewSpring.dataTransferObject.RollbackDto;
import com.turchenkov.NewSpring.model.Client;
import com.turchenkov.NewSpring.model.Operation;
import com.turchenkov.NewSpring.repository.BankRepository;
import com.turchenkov.NewSpring.repository.ClientRepository;
import com.turchenkov.NewSpring.repository.OperationRepository;
import com.turchenkov.NewSpring.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private OperationService operationService;

    @GetMapping("/client/{clientID}/operations")
    public String makeOperation(Model model, @PathVariable("clientID") String clientID) {
        List<Operation> operations;
        Boolean isAdmin = true;

        if ("all".equals(clientID)) {
            operations = new ArrayList<>();
            operationRepository.findAll().forEach(operations::add);
        } else {
            Client client = clientRepository.findById(Long.valueOf(clientID)).get();
            operations = StreamSupport
                    .stream(operationRepository.findAll().spliterator(), false)
                    .filter(operation -> client.getAccount().contains(operation.getSender())
                            || client.getAccount().contains(operation.getReceiver()))
                    .collect(Collectors.toList());
            isAdmin = false;
        }

        model.addAttribute("clientID", clientID);
        model.addAttribute("operations", operations);
        model.addAttribute("admin", isAdmin);
        model.addAttribute("rollback", new RollbackDto());
        return "operations";
    }

    @PostMapping("/client/{clientID}/operations")
    public String rollbackOperation(@ModelAttribute RollbackDto rollbackDto, @PathVariable("clientID") String clientID) {
        Operation operation = operationRepository.findById(rollbackDto.getOperationID()).get();
        operationService.rollback(operation);
        return "redirect:/client/all/operations";
    }

    @GetMapping("/client/{clientID}/newOperation")
    public String newOperationGet(Model model, @PathVariable("clientID") String clientID) {
        model.addAttribute("client", clientRepository.findById(Long.valueOf(clientID)).get());
        model.addAttribute("operation", new OperationDto());
        model.addAttribute("accounts", bankRepository.findAll());
        return "newOperation";
    }

    @PostMapping("/client/{clientID}/newOperation")
    public String newOperationPost(@ModelAttribute OperationDto operationDto, @PathVariable("clientID") String clientID) {
        Client client = clientRepository.findById(Long.valueOf(clientID)).get();
        Operation operation = new Operation();
        operation.setSender(bankRepository.findById(operationDto.getFromAccountID()).get());
        operation.setReceiver(bankRepository.findById(operationDto.getToAccountID()).get());
        operation.setMoney(operationDto.getMoney());
        if (operation.getMoney() == 0) {
            operation.setMoney(0);
        }
        operationService.transfer(operation);
        return "redirect:/client/" + client.getId() + "/operations";
    }
}
