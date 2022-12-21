package com.composite.key.Compositekey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
/**
 * Composite key problem you can solve in two different approches these are
 *  1. using @IdClass
 *  2. using @Embeddable
 * **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class EmployeePkId implements Serializable {

    private int employeeId;
    private int dptId;
}
