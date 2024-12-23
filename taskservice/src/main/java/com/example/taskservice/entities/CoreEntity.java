package com.example.taskservice.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CoreEntity implements Serializable {

    @CreatedDate
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
