package com.turchenkov.NewSpring.repository;

import com.turchenkov.NewSpring.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
}
