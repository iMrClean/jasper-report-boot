package ru.mrclean.report.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mrclean.report.domain.EmployeeDB;
import ru.mrclean.report.repository.EmployeeDbRepository;
import ru.mrclean.report.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final String reportPath = "E:\\report\\src\\main\\resources\\templates\\";

    private final EmployeeRepository employeeRepository;

    private final EmployeeDbRepository employeeDbRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDbRepository employeeDbRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeDbRepository = employeeDbRepository;
    }

    public String generateReport() {
        try {


            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\employee-rpt.jrxml");

            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employeeRepository.getEmpList());

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Websparrow.org");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-Rpt.pdf");

            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;
        } catch (JRException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String generateDBReport() {
        try {

            List<EmployeeDB> employees = employeeDbRepository.findAll();

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(reportPath + "\\employee-rpt-database.jrxml");

            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "Websparrow.org");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Emp-Rpt-Database.pdf");

            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }
}