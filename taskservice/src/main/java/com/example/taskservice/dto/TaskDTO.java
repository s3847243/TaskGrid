package com.example.taskservice.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TaskDTO  {
    private String id;
    private String taskTitle;
    private String taskDescription;
    private String notes;
    //EmployeeId
    private String assignee;
    private Timestamp taskStartDate;
    private String taskStatus;
    private String priorityType;
}
