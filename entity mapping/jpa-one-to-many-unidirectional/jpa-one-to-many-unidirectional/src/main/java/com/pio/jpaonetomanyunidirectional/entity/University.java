package com.pio.jpaonetomanyunidirectional.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "university_id")
    private List<Student> students;

    public University() {
    }

    public University(long id, String name, List<Student> students) {
        this.id = id;
        Name = name;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", students=" + students +
                '}';
    }
}
