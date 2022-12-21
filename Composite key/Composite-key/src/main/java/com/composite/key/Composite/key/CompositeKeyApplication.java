package com.composite.key.Composite.key;

import com.composite.key.Composite.key.entity.Employee;
import com.composite.key.Composite.key.entity.EmployeeIdenty;
import com.composite.key.Composite.key.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompositeKeyApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CompositeKeyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee saveEmp = employeeRepository.save(new Employee(new EmployeeIdenty("e-100", "c-144"), "Amit kumar", "amit@yahoo.co.in", "9876543210"));
        System.out.println(saveEmp);



    }
}
