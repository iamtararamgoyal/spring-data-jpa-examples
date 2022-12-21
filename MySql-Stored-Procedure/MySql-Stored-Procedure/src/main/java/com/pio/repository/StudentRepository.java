package com.pio.repository;

import com.pio.model.Student;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Integer> {
}
