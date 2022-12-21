package com.entity.mappings.repository;

import com.entity.mappings.entity.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {
}
