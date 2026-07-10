package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.request.DepartmentRequest;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/ui/departments")
public class WebDepartmentController {

    private final DepartmentService departmentService;

    public WebDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "department/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new DepartmentRequest());
        return "department/add";
    }

    @PostMapping("/add")
    public String addDepartment(
            @Valid @ModelAttribute("department") DepartmentRequest request,
            BindingResult result) {

        if (result.hasErrors()) {
            return "department/add";
        }

        departmentService.createDepartment(request);
        return "redirect:/ui/departments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        var department = departmentService.getDepartmentById(id);

        DepartmentRequest request = new DepartmentRequest();
        request.setDepartmentName(department.getDepartmentName());
        request.setDescription(department.getDescription());
        request.setStatus(department.getStatus());

        model.addAttribute("departmentId", id);
        model.addAttribute("department", request);

        return "department/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateDepartment(
            @PathVariable Long id,
            @Valid @ModelAttribute("department") DepartmentRequest request,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("departmentId", id);
            return "department/edit";
        }

        departmentService.updateDepartment(id, request);
        return "redirect:/ui/departments";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "redirect:/ui/departments";
    }
}