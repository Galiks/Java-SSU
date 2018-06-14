package com.turchenkov.NewSpring.repository;

import com.turchenkov.NewSpring.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findBySecondName(String secondName);

    Optional<Client> findByLogin(String login);
}
