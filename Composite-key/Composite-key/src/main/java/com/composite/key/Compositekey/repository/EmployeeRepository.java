package com.composite.key.Compositekey.repository;

import com.composite.key.Compositekey.entity.Employee;
import com.composite.key.Compositekey.entity.EmployeePkId;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeePkId> {
}
