package com.entity.onetoone.repository;

import com.entity.onetoone.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {
}
