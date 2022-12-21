package com.entity.mappings.repository;

import com.entity.mappings.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
