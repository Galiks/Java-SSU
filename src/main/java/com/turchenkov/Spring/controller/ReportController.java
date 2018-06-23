package com.turchenkov.Spring.controller;

import com.turchenkov.Spring.dto.ReportDTO;
import com.turchenkov.Spring.model.Report;
import com.turchenkov.Spring.repository.ReportRepository;
import com.turchenkov.Spring.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/report")
    public String reportGet(Model model) {
        model.addAttribute("report", new Report());
        return "report";
    }

    @PostMapping("/report")
    public String reportPost(@ModelAttribute Report report) {
        reportRepository.saveAndFlush(report);
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
}
