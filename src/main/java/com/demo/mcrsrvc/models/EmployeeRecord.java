package com.demo.mcrsrvc.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@Document(collection = "records")
public class EmployeeRecord {

    private String empId;
    private String firstName;
    private String lastName;
    private String dept;

    public EmployeeRecord(String empId, String firstName, String lastName, String dept) {
        super();
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
    }

    public EmployeeRecord(String firstName, String lastName, String dept) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
    }

    public EmployeeRecord(String empId) {
        super();
        this.empId = empId;
    }

}