package com.example.taskservice.dto;
import java.util.*;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String job;
    private int age;
    private Date addedDate;
}
