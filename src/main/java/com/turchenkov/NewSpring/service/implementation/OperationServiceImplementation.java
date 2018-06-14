package com.turchenkov.NewSpring.service.implementation;

import com.turchenkov.NewSpring.exception.ExceptionForOperation;
import com.turchenkov.NewSpring.model.Bank;
import com.turchenkov.NewSpring.model.Operation;
import com.turchenkov.NewSpring.repository.BankRepository;
import com.turchenkov.NewSpring.repository.OperationRepository;
import com.turchenkov.NewSpring.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImplementation implements OperationService {

    private BankRepository bankRepository;

    private OperationRepository operationRepository;

    @Override
    public void transfer(Operation operation) {
        Bank sender = operation.getSender();
        sender.setMoney(sender.getMoney() - operation.getMoney());
        if (sender.getMoney() < 0) {
            try {
                throw new ExceptionForOperation("failed commit");
            } catch (ExceptionForOperation exceptionForOperation) {
                exceptionForOperation.printStackTrace();
            }
        }
        Bank receiver = operation.getReceiver();
        receiver.setMoney(receiver.getMoney() + operation.getMoney());
        bankRepository.save(sender);
        bankRepository.save(receiver);
        operationRepository.save(operation);
    }

    @Override
    public void rollback(Operation operation) {
        Bank sender = operation.getSender();
        sender.setMoney(sender.getMoney() + operation.getMoney());
        Bank receiver = operation.getReceiver();
        receiver.setMoney(receiver.getMoney() - operation.getMoney());
        if (receiver.getMoney() < 0) {
            try {
                throw new ExceptionForOperation("failed rollback");
            } catch (ExceptionForOperation exceptionForOperation) {
                exceptionForOperation.printStackTrace();
            }
        }
        operation.setReverse(true);
        bankRepository.save(sender);
        bankRepository.save(receiver);
        operationRepository.save(operation);
    }
}
