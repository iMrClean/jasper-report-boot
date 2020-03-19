package ru.mrclean.report.repository;

import org.springframework.stereotype.Repository;
import ru.mrclean.report.domain.Employee;

import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> empList = Arrays.asList(
            new Employee(1, "Sandeep", "Data Matrix", "Front-end Developer", 20000),
            new Employee(2, "Prince", "Genpact", "Consultant", 40000),
            new Employee(3, "Gaurav", "Silver Touch ", "Sr. Java Engineer", 47000),
            new Employee(4, "Abhinav", "Akal Info Sys", "CTO", 700000));

    public List<Employee> getEmpList() {
        return empList;
    }

}
