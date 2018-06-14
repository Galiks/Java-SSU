package com.turchenkov.NewSpring.repository;

import com.turchenkov.NewSpring.model.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {
}
