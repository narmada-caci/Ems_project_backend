package com.example.Employee_management.controller;

import com.example.Employee_management.dto.EmployeeDto;
import com.example.Employee_management.service.EmployeeService;
//import jdk.javadoc.internal.tool.JavadocLog;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){

//        if (result.hasErrors()) {
//            return ResponseEntity.ok().build();
//        }
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
@GetMapping("{Id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("Id") long employeeId){
      EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
    }
@GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employee = employeeService.getAllEmployees();
        return ResponseEntity.ok(employee);
    }
@PutMapping("{id}")

    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody  EmployeeDto updateEmployee){
     EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
     return ResponseEntity.ok(employeeDto);
    }
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully...");
    }
}
