package com.entity.manytomany.controller;

import com.entity.manytomany.dao.EmployeeRepository;
import com.entity.manytomany.dao.ProjectRepository;
import com.entity.manytomany.entity.Employee;
import com.entity.manytomany.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);

    }

    @GetMapping
    public List<Employee> getsEmployee() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return employees;
    }

    @PutMapping("/{empId}/projects/{projectId}")
    public Employee addProjectToEmployee(
            @PathVariable("empId") int empId,
            @PathVariable("projectId") int projectId
    ) {

        Employee employee = employeeRepository.findById(empId).get();
        Project project = projectRepository.findById(projectId).get();
        employee.projects.add(project);
        employeeRepository.save(employee);
        return employeeRepository.save(employee);
    }
}

