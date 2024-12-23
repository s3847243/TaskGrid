package com.example.employeeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return new ResponseEntity<EmployeeDTO>(employeeService.save(employeeDTO),HttpStatus.ACCEPTED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){

        return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAll(),HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable("id") String id, @RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        return new ResponseEntity<EmployeeDTO>(employeeService.update(employeeDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable("id") String id) {
        return new ResponseEntity<EmployeeDTO>(employeeService.delete(id), HttpStatus.OK);
    }
}
