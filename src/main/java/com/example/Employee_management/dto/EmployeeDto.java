package com.example.Employee_management.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    private String firstName;
    private String lastName;
//    @Email
    private String email;
    private String phonenumber;

    private String jobtitle;
    private double salary;
    private String  department;
}
