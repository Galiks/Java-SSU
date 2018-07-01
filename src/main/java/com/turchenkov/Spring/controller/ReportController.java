package com.turchenkov.Spring.controller;

import com.turchenkov.Spring.dto.ReportDTO;
import com.turchenkov.Spring.model.Report;
import com.turchenkov.Spring.repository.ReportRepository;
import com.turchenkov.Spring.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @Autowired
    private ReportRepository reportRepository;


    @GetMapping("/report")
    public String reportGet(Model model){
        model.addAttribute("report", new Report());

        return "report";
    }

    @PostMapping("/report")
    public String reportPost(@ModelAttribute Report report){
        reportRepository.save(report);

        return "redirect:/reports";
    }

    @GetMapping("/reports")
    public String allReportsGet(Model model) {
        List<Report> reports = new ArrayList<>();
        reportRepository.findAll().forEach(reports::add);
        model.addAttribute("reports", reports);
        model.addAttribute("reportDto", new ReportDTO());
        return "reports";
    }

    @PostMapping("/reports")
    public String allReportsPost(@ModelAttribute ReportDTO reportDTO) {
        return "redirect:/reports";
    }

    @GetMapping("/balance")
    public String balanceGet(Model model) {
        model.addAttribute("balance", reportService.balance());

        return "balance";
    }

    @GetMapping("/edit/{id}")
    public String editGet(Model model, @PathVariable("id") String id){
        model.addAttribute(reportRepository.findById(Long.parseLong(id)).get());

        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@ModelAttribute Report report, @PathVariable("id") String id,
                           @RequestParam String date,
                           @RequestParam String number,
                           @RequestParam String cost,
                           @RequestParam String prepayment,
                           @RequestParam String payment,
                           @RequestParam String consumption,
                           @RequestParam String description){
        report.setId(Long.parseLong(id));
        report.setDate(date);
        report.setNumber(Integer.parseInt(number));
        report.setCost(Integer.parseInt(cost));
        report.setPrepayment(Integer.parseInt(prepayment));
        report.setPayment(Integer.parseInt(payment));
        report.setConsumption(Integer.parseInt(consumption));
        report.setDescription(description);

        reportRepository.save(report);

        return "redirect:/reports";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(Model model, @PathVariable("id") String id){
        model.addAttribute(reportRepository.findById(Long.parseLong(id)).get());

        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@ModelAttribute Report report, @PathVariable("id") Long id){
        reportRepository.delete(report);

        return "redirect:/reports";
    }
}
