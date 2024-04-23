package com.example.Employee_management.impl;

import com.example.Employee_management.Mapper.EmployeeMapper;
import com.example.Employee_management.dto.EmployeeDto;
import com.example.Employee_management.entity.Employee;
import com.example.Employee_management.exception.ResouceNotFoundException;
import com.example.Employee_management.repository.EmployeeRepository;
import com.example.Employee_management.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)

                .orElseThrow(() -> new ResouceNotFoundException("Employee is not exists with given id :"  +employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map((employees) ->  EmployeeMapper.mapToEmployeeDto(employees)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResouceNotFoundException("Employee is not found with given Id :" +employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setDepartment(updateEmployee.getDepartment());
        employee.setPhonenumber(updateEmployee.getPhonenumber());
        employee.setEmail(updateEmployee.getEmail());
        employee.setJobtitle(updateEmployee.getJobtitle());
        employee.setSalary(updateEmployee.getSalary());
        employee.setDepartment(updateEmployee.getDepartment());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)

                .orElseThrow(() -> new ResouceNotFoundException("Employee is not exists with given id :"  +employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
