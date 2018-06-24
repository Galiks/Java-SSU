package com.turchenkov.Spring.repository;

import com.turchenkov.Spring.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("SELECT SUM(r.prepayment) FROM Report as r")
    int getSumOfPrepayment();

    @Query("SELECT SUM(r.payment) FROM Report as r")
    int getSumOfPayment();

    @Query("SELECT SUM(r.consumption) FROM Report as r")
    int getSumOfConsumption();

    @Query("SELECT COUNT(r.consumption) FROM Report as r")
    int countByConsumption();

    @Query("SELECT COUNT(r.payment) FROM Report as r")
    int countByPayment();

    @Query("SELECT COUNT(r.prepayment) FROM Report as r")
    int countByPrepayment();

    Optional<Report> findByNumber(int number);

    void deleteById(Long id);
}
