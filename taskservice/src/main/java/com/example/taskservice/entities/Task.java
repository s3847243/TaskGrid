package com.example.taskservice.entities;

import java.sql.Timestamp;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name  = "tasks")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Task extends CoreEntity{

    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    @Column(name = "id")
    private String id;
    @Getter
    @Setter
    @Column(name = "title")
    private String taskTitle;
    @Getter
    @Setter
    @Column(name = "description",length = 600)
    private String taskDescription;
    @Getter
    @Setter
    @Column(name = "notes")
    private String notes;
    @Getter
    @Setter
    @Column(name = "assignee",length = 50)
    private String assignee;
    @Getter
    @Setter
    @Column(name = "startdate")
    private Timestamp taskStartDate;
    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus taskStatus;
    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private PriorityType priorityType;
    
}
