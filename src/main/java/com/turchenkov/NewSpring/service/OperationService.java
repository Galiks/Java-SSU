package com.turchenkov.NewSpring.service;

import com.turchenkov.NewSpring.model.Operation;

public interface OperationService {
    void transfer(Operation operation);

    void rollback(Operation operation);
}
