package com.pio.jpaonetomanyunidirectional.repository;

import com.pio.jpaonetomanyunidirectional.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
