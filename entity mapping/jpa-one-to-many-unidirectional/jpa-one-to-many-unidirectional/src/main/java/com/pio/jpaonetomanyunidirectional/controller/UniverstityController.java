package com.pio.jpaonetomanyunidirectional.controller;

import com.pio.jpaonetomanyunidirectional.entity.Student;
import com.pio.jpaonetomanyunidirectional.entity.University;
import com.pio.jpaonetomanyunidirectional.repository.StudentRepository;
import com.pio.jpaonetomanyunidirectional.repository.UniversityRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniverstityController {
    @Autowired
    UniversityRepositry universityRepositry;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/university")
    public University createUniversity(@RequestBody University university) {
        return universityRepositry.save(university);
    }

    @GetMapping("/university")
    public List<University> getUniversities() {
        List<University> universities = (List<University>) universityRepositry.findAll();
        return universities;
    }

    @GetMapping("/university/{id}")
    public University getUniversity(@PathVariable("id") long id) {
        University university = universityRepositry.findById(id).get();
        return university;

    }

    @PutMapping("/university/{id}")
    public University updateUniversity(@PathVariable("id") long id, @RequestBody University university) {
        University university1 = universityRepositry.findById(id).get();

        // university1.setName(university.getName());

        return universityRepositry.save(university);

    }

    @PutMapping("/university/{unvid}/student/{stdid}")
    public University updateUniversityAndStudent(@PathVariable("unvid") long unvid, @PathVariable("stdid") long stdid) {
        University university = universityRepositry.findById(unvid).get();
        Student student = studentRepository.findById(stdid).get();
        List<Student> students = university.getStudents();
        students.add(student);
        university.setStudents(students);
        return universityRepositry.save(university);

    }

    @DeleteMapping("/university/{id}")
    public void deleteUniversity(@PathVariable("id") long id) {
        /*University university = universityRepositry.findById(id).get();
        System.out.println(university);*/
        universityRepositry.deleteById(id);
    }
}
