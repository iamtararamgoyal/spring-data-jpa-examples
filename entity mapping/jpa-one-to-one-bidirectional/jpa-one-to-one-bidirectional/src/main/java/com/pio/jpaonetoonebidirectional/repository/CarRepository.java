package com.pio.jpaonetoonebidirectional.repository;

import com.pio.jpaonetoonebidirectional.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
