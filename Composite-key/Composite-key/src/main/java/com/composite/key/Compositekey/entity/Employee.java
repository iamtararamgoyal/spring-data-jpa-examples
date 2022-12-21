package com.composite.key.Compositekey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


/**
 * Composite key problem you can solve in two different approches these are
 * 1. using @IdClass
 * 2. using @Em
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(EmployeePkId.class) this is use only for approch 1

public class Employee {

    /*@Id
    private int employeeId;
    @Id
    private int dptId;
    this is used for approch 1
    */
    // this is used for approch 2
    @EmbeddedId
    private EmployeePkId employeePkId;
    private String name;
    private String email;
    private String phone;
}
