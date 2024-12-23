package com.example.employeeservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.entities.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String>{

    
    
}
