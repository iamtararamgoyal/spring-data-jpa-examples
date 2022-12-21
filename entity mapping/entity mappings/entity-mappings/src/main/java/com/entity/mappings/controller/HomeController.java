package com.entity.mappings.controller;

import com.entity.mappings.entity.User;
import com.entity.mappings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one2one")
public class HomeController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/saveuser")
    public String saveUser(@RequestBody User user) {
        System.out.println(user);
        repository.save(user);
        return "";
    }
}
