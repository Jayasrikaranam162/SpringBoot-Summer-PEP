package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.DashboardResponse;
import com.example.demo.service.DashboardService;

@Controller
public class WebDashboardController {

    private final DashboardService dashboardService;

    public WebDashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        DashboardResponse dashboard = dashboardService.getAdminDashboard();

        model.addAttribute("dashboard", dashboard);

        return "dashboard/dashboard";
    }
}