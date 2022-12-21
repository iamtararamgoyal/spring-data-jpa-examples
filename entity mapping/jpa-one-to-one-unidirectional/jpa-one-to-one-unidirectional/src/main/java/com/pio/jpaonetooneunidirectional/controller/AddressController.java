package com.pio.jpaonetooneunidirectional.controller;

import com.pio.jpaonetooneunidirectional.entity.Address;
import com.pio.jpaonetooneunidirectional.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/address")
    public List<Address> getAddresss() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        return addresses;

    }

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable("id") long id) {
        Address address = addressRepository.findById(id).get();
        return address;
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
        Address addresss = addressRepository.findById(id).get();
        addresss.setCity(address.getCity());
        addresss.setCountry(address.getCountry());
        addresss.setState(address.getState());
        addresss.setStreet(address.getStreet());
        return addressRepository.save(addresss);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable("id") long id) {
        addressRepository.deleteById(id);
    }
}
