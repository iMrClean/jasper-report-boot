package ru.mrclean.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrclean.report.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeReportController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeReportController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/report")
    public String empReport() {
        return employeeService.generateReport();
    }

    @GetMapping("/reportdb")
    public String empReportDB() {
        return employeeService.generateDBReport();
    }
}