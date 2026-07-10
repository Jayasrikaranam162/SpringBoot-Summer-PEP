package com.example.demo.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ui/employees")
public class WebEmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public WebEmployeeController(EmployeeService employeeService,
                                 DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee(
            @RequestParam Long departmentId,
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "employee/add";
        }

        employeeService.createEmployee(employee, departmentId);
        return "redirect:/ui/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());

        return "employee/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @RequestParam Long departmentId,
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "employee/edit";
        }

        employeeService.updateEmployee(id, employee, departmentId);
        return "redirect:/ui/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/ui/employees";
    }
}