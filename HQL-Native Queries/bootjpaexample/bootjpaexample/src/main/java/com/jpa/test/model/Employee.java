package com.jpa.test.model;

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private String empCity;
    private float empSalary;

    public Employee() {
    }

    public Employee(int eId, String empName, String empCity, float empSalary) {
        this.empId = eId;
        this.empName = empName;
        this.empCity = empCity;
        this.empSalary = empSalary;
    }

    public int geteId() {
        return empId;
    }

    public void seteId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + empId +
                ", empName='" + empName + '\'' +
                ", empCity='" + empCity + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

}
