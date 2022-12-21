package com.pio.jpaonetoonebidirectional.controller;

import com.pio.jpaonetoonebidirectional.entity.Car;
import com.pio.jpaonetoonebidirectional.entity.Owner;
import com.pio.jpaonetoonebidirectional.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @PostMapping("/owner")
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @GetMapping("/owner")
    public List<Owner> getOwners() {
        List<Owner> owners = (List<Owner>) ownerRepository.findAll();
        return owners;
    }

    @GetMapping("/owner/{id}")
    public Owner getOwner(@PathVariable("id") long id) {
        Owner owner = ownerRepository.findById(id).get();
        return owner;

    }

    @PutMapping("/owner/{id}")
    public Owner updateOwner(@PathVariable("id") long id, @RequestBody Owner owner) {

        Owner own = ownerRepository.findById(id).get();
        own.setName(owner.getName());
        Car car = own.getCar();
        car.setId(car.getId());
        car.setModel(owner.getCar().getModel());
        own.setCar(car);
        return ownerRepository.save(own);

    }

    @DeleteMapping("/owner/{id}")
    public void deleteOwner(@PathVariable("id") long id) {
        ownerRepository.deleteById(id);

    }
}
