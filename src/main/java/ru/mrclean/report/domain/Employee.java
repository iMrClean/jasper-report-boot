package ru.mrclean.report.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {

    private Integer id;

    private String name;

    private String organization;

    private String designation;

    private Integer salary;

}
