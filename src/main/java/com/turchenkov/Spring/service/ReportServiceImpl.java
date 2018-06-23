package com.turchenkov.Spring.service;

import com.turchenkov.Spring.repository.ReportRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @SneakyThrows
    @Override
    public int balance() {
        if(reportRepository.countByConsumption() == 0 || reportRepository.countByPayment() == 0 || reportRepository.countByPrepayment() == 0){
            throw new Exception("I don't have data. Please return back");
        }
        int allPrepayment = reportRepository.getSumOfPrepayment();
        int allPayment = reportRepository.getSumOfPayment();
        int allConsumption = reportRepository.getSumOfConsumption();
        int balance = allPrepayment+allPayment-allConsumption;

        return balance;
    }
}
