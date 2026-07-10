package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AssetAssignment;
import com.example.demo.service.AssetAssignmentService;
import com.example.demo.service.AssetService;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/ui/assignments")
public class WebAssignmentController {

    private final AssetAssignmentService assignmentService;
    private final AssetService assetService;
    private final EmployeeService employeeService;

    public WebAssignmentController(AssetAssignmentService assignmentService,
                                   AssetService assetService,
                                   EmployeeService employeeService) {
        this.assignmentService = assignmentService;
        this.assetService = assetService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listAssignments(Model model) {
        model.addAttribute("assignments", assignmentService.getAllAssignments());
        return "assignment/list";
    }

    @GetMapping("/add")
    public String showAssignForm(Model model) {
        model.addAttribute("assignment", new AssetAssignment());
        model.addAttribute("assets", assetService.getAllAssets());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "assignment/add";
    }

    @PostMapping("/add")
    public String assignAsset(@RequestParam Long assetId,
                              @RequestParam Long employeeId,
                              @ModelAttribute AssetAssignment assignment,
                              Model model) {

        try {
            assignmentService.assignAsset(assetId, employeeId, assignment);
        } catch (Exception e) {
            model.addAttribute("assignment", assignment);
            model.addAttribute("assets", assetService.getAllAssets());
            model.addAttribute("employees", employeeService.getAllEmployees());
            model.addAttribute("errorMessage", e.getMessage());
            return "assignment/add";
        }

        return "redirect:/ui/assignments";
    }

    @GetMapping("/return/{id}")
    public String returnAsset(@PathVariable Long id, Model model) {

        try {
            assignmentService.returnAsset(id);
        } catch (Exception e) {
            model.addAttribute("assignments", assignmentService.getAllAssignments());
            model.addAttribute("errorMessage", e.getMessage());
            return "assignment/list";
        }

        return "redirect:/ui/assignments";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return "redirect:/ui/assignments";
    }
}