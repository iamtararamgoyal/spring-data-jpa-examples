package com.entity.manytomany.dao;

import com.entity.manytomany.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
