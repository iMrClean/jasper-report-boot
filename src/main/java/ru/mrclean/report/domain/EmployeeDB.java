package ru.mrclean.report.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "emp")
public class EmployeeDB {

    @Id
    @Column(name = "empno")
    private Long empNo;
    @Column(name = "ename")
    private String empName;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Long manager;
    @Column(name = "hiredate")
    private Date hireDate;
    @Column(name = "sal")
    private Long salary;
    @Column(name = "comm")
    private Long commission;
    @Column(name = "deptno")
    private Long deptNo;

}