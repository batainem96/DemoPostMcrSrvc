package com.demo.mcrsrvc.services;

import com.demo.mcrsrvc.util.exceptions.DuplicateRecordException;
import com.demo.mcrsrvc.util.exceptions.InvalidRequestException;
import com.demo.mcrsrvc.models.EmployeeRecord;
import com.demo.mcrsrvc.repositories.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * The RecordsService Class is responsible for applying business logic to incoming HTTP Requests from the Controller
 * layer and passing them to the Data Access layer for querying the Employee Records collection.
 */
@Service
public class RecordsService {

    private final RecordsRepository recordsRepository;

    @Autowired
    public RecordsService(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    /**
     * This method verifies the record passed in before sending to repository layer (throws exception if record is bad).
     * @param empId - employee ID
     * @param firstName - first name
     * @param lastName - last name
     * @param dept - department
     */
    public EmployeeRecord createRecord(String empId, String firstName, String lastName, String dept) {

        EmployeeRecord record = new EmployeeRecord(empId, firstName, lastName, dept);

        boolean isExceptionBeingThrown = false;
        String exceptionMessage = "The following input field(s) is/are invalid: ";

        // Validate each field in record and append exceptionMessage as necessary
        if(record.getEmpId() == null || record.getEmpId().trim().isEmpty()) {
            isExceptionBeingThrown = true;
            exceptionMessage += "empId";
        }
        if(record.getFirstName() == null || record.getFirstName().trim().isEmpty()) {
            if(isExceptionBeingThrown) exceptionMessage += ", ";
            isExceptionBeingThrown = true;
            exceptionMessage += "firstName";
        }
        if(record.getLastName() == null || record.getLastName().trim().isEmpty()) {
            if(isExceptionBeingThrown) exceptionMessage += ", ";
            isExceptionBeingThrown = true;
            exceptionMessage += "lastName";
        }
        if(record.getDept() == null || record.getDept().trim().isEmpty()) {
            if(isExceptionBeingThrown) exceptionMessage += ", ";
            exceptionMessage += "dept";
        }

        exceptionMessage += ".";

        // One or more fields in record were invalid
        if(isExceptionBeingThrown) {
            throw new InvalidRequestException(exceptionMessage);
        }

        try {
            return recordsRepository.insert(record);
        } catch(DuplicateKeyException e) {
            throw new DuplicateRecordException("empId: " + record.getEmpId() + " already exists!");
        }

    }

}
