package com.pio.controller;

import com.pio.model.Student;
import com.pio.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Student.class);
    @Autowired
    StudentService studentService;

    /*
    * count total numbers of students handler
    * */
    @GetMapping("/count")
    public int countTotalStudents() {
        int student = studentService.countTotalStudents();
        return student;
    }

    /**
     * gets all the students handler
     * **/
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();

    }
    /**
     * gets all the students by result handler
     * **/
    @GetMapping("/{result}")
    public List<Student> getStudentsByResult(@PathVariable("result") String result) {
        return studentService.getStudentsByResult(result);
    }

    /**
     * count total number of students by result handler
     * **/
    @GetMapping("/result/{res}")
    public int countStudentsByResult(@PathVariable("res") String result) {
        return studentService.countStudentByResult(result);
    }

}
