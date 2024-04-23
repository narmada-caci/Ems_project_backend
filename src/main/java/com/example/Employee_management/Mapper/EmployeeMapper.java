package com.example.Employee_management.Mapper;

import com.example.Employee_management.dto.EmployeeDto;
import com.example.Employee_management.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhonenumber(),
                employee.getJobtitle(),
                employee.getSalary(),
                employee.getDepartment()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPhonenumber(),
                employeeDto.getJobtitle(),
                employeeDto.getSalary(),
                employeeDto.getDepartment()
        );
    }
}
