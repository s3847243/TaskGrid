package com.example.taskservice.entities;

public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In_progress"),
    CLOSED("Closed");

    private String status;

    TaskStatus(String status){
        this.status = status;
    }
}
