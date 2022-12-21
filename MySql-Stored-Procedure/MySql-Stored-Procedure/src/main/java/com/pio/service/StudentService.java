package com.pio.service;

import com.pio.model.Student;
import com.pio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * gets all the students
     */
    public List<Student> getStudents() {
        return (List<Student>) entityManager.createNamedStoredProcedureQuery("getStudents").getResultList();
    }

    /**
     * gets all the students by result
     */
    public List<Student> getStudentsByResult(String result) {
        return (List<Student>) entityManager.createNamedStoredProcedureQuery("getStudentsByResult").setParameter("result", result).getResultList();
    }

    /**
     * gets total counts of students
     */
    public int countTotalStudents() {
        return (Integer) entityManager.createNamedStoredProcedureQuery("countTotalStudents").getOutputParameterValue("totalStudents");

    }

    /**
     * gets total count of students by result
     */
    public int countStudentByResult(String result) {
        return (Integer) entityManager.createNamedStoredProcedureQuery("countStudentByResult").setParameter("result", result).getOutputParameterValue("totalStudentsByResult");
    }
}
