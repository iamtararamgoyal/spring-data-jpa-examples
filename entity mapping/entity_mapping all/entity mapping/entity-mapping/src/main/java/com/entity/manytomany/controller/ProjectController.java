package com.entity.manytomany.controller;

import com.entity.manytomany.dao.ProjectRepository;
import com.entity.manytomany.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getProjects() {
        return (List<Project>) projectRepository.findAll();
    }


    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }


}
