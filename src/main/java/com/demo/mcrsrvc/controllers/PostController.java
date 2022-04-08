package com.demo.mcrsrvc.controllers;

import com.demo.mcrsrvc.models.EmployeeRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/record")
public class PostController {

    @PostMapping
    public EmployeeRecord createNewRecord(HttpServletRequest request) {

        return new EmployeeRecord("1", "two", "three", "four");

    }

}
