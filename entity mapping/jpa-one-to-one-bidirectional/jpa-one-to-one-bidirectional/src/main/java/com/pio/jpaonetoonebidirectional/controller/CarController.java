package com.pio.jpaonetoonebidirectional.controller;

import com.pio.jpaonetoonebidirectional.entity.Car;
import com.pio.jpaonetoonebidirectional.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/car")
    public List<Car> getCars() {
        List<Car> cars = (List<Car>) carRepository.findAll();
        return cars;

    }

    @PostMapping("/car")
    public Car createCars(@RequestBody Car car) {
        return carRepository.save(car);

    }
    @PutMapping("/car/{id}")
    public Car updateCars(@RequestBody Car car, @PathVariable("id") long id) {
        Car cr = carRepository.findById(id).get();
        cr.setModel(car.getModel());
        return carRepository.save(car);

    }
}
