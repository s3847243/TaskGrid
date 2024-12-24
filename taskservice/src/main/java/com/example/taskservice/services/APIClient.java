package com.example.taskservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.taskservice.dto.EmployeeDTO;

@FeignClient(url = "http://localhost:7202",value = "employeeservice")
public interface APIClient {

    @GetMapping("/employees/{id}")
    public EmployeeDTO getById(@PathVariable String id);
}