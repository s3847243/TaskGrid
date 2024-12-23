package com.example.taskservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskservice.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,String>{
    
}
