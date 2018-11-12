package com.turchenkov.Spring.repository;

import com.turchenkov.Spring.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
