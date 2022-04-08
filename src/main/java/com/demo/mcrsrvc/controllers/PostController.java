package com.demo.mcrsrvc.controllers;

import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class PostController {

    RecordsService recordsService;

    @Autowired
    public PostController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @PostMapping
    public EmployeeRecord createNewRecord(
            @RequestParam String empId,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dept
    ) {

        return recordsService.createRecord(empId, firstName, lastName, dept);

    }

}
