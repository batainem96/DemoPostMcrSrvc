package com.demo.mcrsrvc.repositories;

import com.demo.mcrsrvc.models.EmployeeRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsRepository extends MongoRepository<EmployeeRecord, String> {

}