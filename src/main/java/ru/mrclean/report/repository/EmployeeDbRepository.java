package ru.mrclean.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrclean.report.domain.EmployeeDB;

@Repository
public interface EmployeeDbRepository extends JpaRepository<EmployeeDB, Long> {

}
