package com.entity.onetoone.repository;

import com.entity.onetoone.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
