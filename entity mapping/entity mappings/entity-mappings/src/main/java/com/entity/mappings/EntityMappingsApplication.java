package com.entity.mappings;

;
import com.entity.mappings.entity.User;
import com.entity.mappings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class EntityMappingsApplication implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EntityMappingsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
