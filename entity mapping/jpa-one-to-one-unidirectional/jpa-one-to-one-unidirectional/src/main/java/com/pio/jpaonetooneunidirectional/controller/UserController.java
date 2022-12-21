package com.pio.jpaonetooneunidirectional.controller;

import com.pio.jpaonetooneunidirectional.entity.Address;
import com.pio.jpaonetooneunidirectional.entity.User;
import com.pio.jpaonetooneunidirectional.repository.AddressRepository;
import com.pio.jpaonetooneunidirectional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userRepository.findById(id).get();

    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> users = userRepository.findById(id);
        User usr = null;
        if (!users.isEmpty()) {
            usr = users.get();
            usr.setFirstName(user.getFirstName());
            usr.setLastName(user.getLastName());
            userRepository.save(usr);
        }
        return usr;
    }

    @PutMapping("/user/{usrId}/address/{addressId}")
    public User updateUserAndAddress(@PathVariable("usrId") long usrId, @PathVariable("addressId") long addressId) {
        User user = userRepository.findById(usrId).get();
        Address address = addressRepository.findById(addressId).get();
        user.setAddress(address);
        userRepository.save(user);
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

}
