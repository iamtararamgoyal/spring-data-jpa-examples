package com.composite.key.Composite.key.repository;

import com.composite.key.Composite.key.entity.Employee;
import com.composite.key.Composite.key.entity.EmployeeIdenty;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeIdenty> {
}
