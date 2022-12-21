package com.pio.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(name = "getStudents", procedureName = "sp_getStudents", resultClasses = {Student.class}),
                @NamedStoredProcedureQuery(
                        name = "countTotalStudents",
                        procedureName = "sp_countTotalStudent",
                        parameters = {
                                @StoredProcedureParameter(
                                        mode = ParameterMode.OUT,
                                        name = "totalStudents",
                                        type = Integer.class)
                        }),
                @NamedStoredProcedureQuery(
                        name = "countStudentByResult",
                        procedureName = "sp_countStudentByResult",
                        parameters = {
                                @StoredProcedureParameter(
                                        mode = ParameterMode.INOUT,
                                        name = "totalStudentsByResult",
                                        type = Integer.class
                                ),
                                @StoredProcedureParameter(
                                        mode = ParameterMode.IN,
                                        name = "result",
                                        type = String.class
                                )
                        }
                ),
                @NamedStoredProcedureQuery(
                        name = "getStudentsByResult",
                        procedureName = "sp_getStudentsByResult",
                        parameters = {
                                @StoredProcedureParameter(
                                        mode = ParameterMode.IN,
                                        name = "result",
                                        type = String.class
                                )
                        },
                        resultClasses = {Student.class}
                )
        }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float marks;
    private String result;

    public Student() {
    }

    public Student(int id, String name, float marks, String result) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.result = result;
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

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", result='" + result + '\'' +
                '}';
    }
}
