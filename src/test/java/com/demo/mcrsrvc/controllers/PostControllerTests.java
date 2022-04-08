package com.demo.mcrsrvc.controllers;

import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.services.RecordsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostControllerTests {

    @InjectMocks
    PostController postCotnroller;

    @Mock
    RecordsService recordsService;

    @Test
    public void createNewRecord_whenGivenParams_returnsEmployeeRecord_thenAssertionSucceeds() {

        EmployeeRecord expectedRecord = new EmployeeRecord("123", "John", "Doe", "IT");

        Mockito.when(recordsService.createRecord("123", "John", "Doe", "IT"))
                .thenReturn(expectedRecord);

        EmployeeRecord actualRecord = postCotnroller.createNewRecord("123", "John", "Doe", "IT");

        assertEquals(actualRecord, expectedRecord);

    }

}
