package com.entity.onetoone.controller;

import com.entity.onetoone.entities.User;
import com.entity.onetoone.repository.UserProfileRepository;
import com.entity.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProfileRepository userProfileRepository;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User save = userRepository.save(user);
            return new ResponseEntity<User>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = (List<User>) userRepository.findAll();
            if (!users.isEmpty())
                return new ResponseEntity<List<User>>(users, HttpStatus.OK);
            else
                return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("userId") int userId) {
        try {
            Optional<User> users = userRepository.findById(userId);
            if (!users.isEmpty())
                return new ResponseEntity<Optional<User>>(users, HttpStatus.OK);
            else
                return new ResponseEntity<Optional<User>>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Optional<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        try {
            Optional<User> users = userRepository.findById(userId);
            User usr;
            if (!users.isEmpty()) {
                usr = users.get();
                usr.setUserProfile(user.getUserProfile());
                usr.setFirstName(user.getFirstName());
                usr.setLastName(user.getLastName());
                usr.setPassword(user.getPassword());
                User save = userRepository.save(usr);
                return new ResponseEntity<User>(save, HttpStatus.OK);
            } else
                return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId) {
        try {
            Optional<User> users = userRepository.findById(userId);
            if (!users.isEmpty()) {
                userRepository.deleteById(userId);
                return new ResponseEntity<User>(HttpStatus.OK);
            } else
                return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
