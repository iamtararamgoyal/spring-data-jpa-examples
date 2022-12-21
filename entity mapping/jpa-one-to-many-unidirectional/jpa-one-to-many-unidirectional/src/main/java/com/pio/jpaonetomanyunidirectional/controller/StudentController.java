package com.pio.jpaonetomanyunidirectional.controller;

import com.pio.jpaonetomanyunidirectional.entity.Student;
import com.pio.jpaonetomanyunidirectional.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        return studentRepository.findById(id).get();
    }

    @PutMapping("/student/{id}")
    public Student updateStudents(@PathVariable("id") long id, @RequestBody Student student) {
        Student student1 = studentRepository.findById(id).get();
        student1.setName(student.getName());
        return studentRepository.save(student1);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudents(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }
}
