package com.example.notificationservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TaskNotificationDTO implements Serializable{
    private String taskId;
    private String employeeId;
    private String taskTitle;
    private String taskDescription;
}
