package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DamageReport;
import com.example.demo.service.AssetService;
import com.example.demo.service.DamageReportService;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/ui/damage-reports")
public class WebDamageReportController {

    private final DamageReportService damageReportService;
    private final AssetService assetService;
    private final EmployeeService employeeService;

    public WebDamageReportController(DamageReportService damageReportService,
                                     AssetService assetService,
                                     EmployeeService employeeService) {
        this.damageReportService = damageReportService;
        this.assetService = assetService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listDamageReports(Model model) {
        model.addAttribute("reports", damageReportService.getAllDamageReports());
        return "damage/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("damageReport", new DamageReport());
        model.addAttribute("assets", assetService.getAllAssets());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "damage/add";
    }

    @PostMapping("/add")
    public String createDamageReport(
            @RequestParam Long assetId,
            @RequestParam Long employeeId,
            @ModelAttribute DamageReport damageReport,
            Model model) {

        try {
            damageReportService.createDamageReport(assetId, employeeId, damageReport);
        } catch (Exception e) {
            model.addAttribute("damageReport", damageReport);
            model.addAttribute("assets", assetService.getAllAssets());
            model.addAttribute("employees", employeeService.getAllEmployees());
            model.addAttribute("errorMessage", e.getMessage());
            return "damage/add";
        }

        return "redirect:/ui/damage-reports";
    }

    @GetMapping("/resolve/{id}")
    public String showResolveForm(@PathVariable Long id, Model model) {
        model.addAttribute("report", damageReportService.getDamageReportById(id));
        return "damage/resolve";
    }

    @PostMapping("/resolve/{id}")
    public String resolveDamageReport(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam String adminRemarks) {

        damageReportService.updateReportStatus(id, status, adminRemarks);
        return "redirect:/ui/damage-reports";
    }

    @GetMapping("/delete/{id}")
    public String deleteDamageReport(@PathVariable Long id) {
        damageReportService.deleteDamageReport(id);
        return "redirect:/ui/damage-reports";
    }
}