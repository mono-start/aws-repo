package com.rms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    Long employeeId;
    String employeeName;
    Long age;
    String department;
    String gender;
    Double salary;
}
