package com.example.taskservice.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(indexName = "taskdetail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class TaskDetail implements Serializable {
    @Id
    private String id;
    private String employeeId;
    private String employeeName;
    private String employeeSurname;
    private String taskTitle;
    private String taskDescription;
    private String status;
    private String priority;
    
}
