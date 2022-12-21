package com.composite.key.Compositekey.controller;

import com.composite.key.Compositekey.entity.Employee;
import com.composite.key.Compositekey.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee) {

        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    @GetMapping("/view-employee")
    public List<Employee> getAllEmployee() {
        List<Employee> employees = StreamSupport.stream(employeeRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return employees;
    }
}
