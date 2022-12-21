package com.pio.jpaonetomanyunidirectional.repository;

import com.pio.jpaonetomanyunidirectional.entity.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepositry extends CrudRepository<University, Long> {
}
