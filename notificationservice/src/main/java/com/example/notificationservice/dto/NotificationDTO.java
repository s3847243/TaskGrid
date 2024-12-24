package com.example.notificationservice.dto;
import jakarta.persistence.Column;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private long id;
    private String taskId;
    private String employeeId;
    private String taskTitle;
    private String taskDescription;
}