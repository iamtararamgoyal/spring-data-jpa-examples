package com.composite.key.Composite.key.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
@EqualsAndHashCode
public class EmployeeIdenty implements Serializable {

    private String employeeId;
    private String companyId;

}
