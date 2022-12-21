package com.entity.manytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "emp_work",
            joinColumns = {@JoinColumn(name = "emp_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}

    )
    public Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(int id, String name, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
