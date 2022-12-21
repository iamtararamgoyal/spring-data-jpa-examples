package com.pio.jpaonetooneunidirectional.repository;

import com.pio.jpaonetooneunidirectional.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
