package com.example.employeeservice.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.entities.Employee;

public interface EmployeeService {
    public List<EmployeeDTO>getAll();

    public EmployeeDTO getById(String Id);

    public EmployeeDTO save(EmployeeDTO employeeDTO);

    public EmployeeDTO delete(String Id);

    public EmployeeDTO update(EmployeeDTO employeeDTO);

    public Page<EmployeeDTO> findPagination(int pageSize, int pageno, String sortField, String sortDirection);
}
