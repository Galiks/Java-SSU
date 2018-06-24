package com.turchenkov.Spring.controller;

import com.turchenkov.Spring.dto.ReportDTO;
import com.turchenkov.Spring.model.Report;
import com.turchenkov.Spring.repository.ReportRepository;
import com.turchenkov.Spring.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    @Autowired
    private ReportRepository reportRepository;

    //<editor-fold desc="main">
    private String reportInfo(Model model, Report report) {
        model.addAttribute("report", report);
        model.addAttribute("reportID", report.getId());
        return "report";
    }

//    @GetMapping("/report")
//    public String reportGet(Model model) {
//
//        return reportInfo(model, new Report());
//    }

//    @PostMapping("/report/{reportID}")
//    public String reportPost(@ModelAttribute Report report, @PathVariable("reportID") String reportID) {
//        reportRepository.saveAndFlush(report);
//        return "redirect:/reports";
//    }

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
    public String editGet(Model model, @PathVariable("id") String id) {
        return reportInfo(model.addAttribute(id), reportRepository.findById(Long.parseLong(id)).get());
    }

    @PostMapping("/edit/{id}")
    public String editPost(@ModelAttribute Report report, @PathVariable("id") String id) {
        report.setId(Long.parseLong(id));
        reportRepository.save(report);
        return "redirect:/reports";
    }

//    @GetMapping("/delete")
//    public String deleteGet(@PathVariable("reportID") String reportID) {
//        return "delete";
//    }
//
//    @PostMapping("/delete")
//    public String deletePost(@ModelAttribute Report report){
//        reportRepository.delete(reportRepository.findById(report.getId()).get());
//        return "redirect:/reports";
//    }
    //</editor-fold>
}
