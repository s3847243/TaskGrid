package com.example.taskservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskservice.dto.TaskDTO;
import com.example.taskservice.services.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") String id) {
        return new ResponseEntity<TaskDTO>(taskService.getById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getall() {

        return new ResponseEntity<List<TaskDTO>>(taskService.getAllTasks(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) throws JsonProcessingException{
        System.out.println("Received TaskDTO: " + taskDTO);

        return new ResponseEntity<TaskDTO>(taskService.saveTask(taskDTO),HttpStatus.CREATED);

        // save to elastic search

    }
    @GetMapping("/pagination/{pageNo}/{pageSize}")
    public ResponseEntity<List<TaskDTO>> taskpagination(@PathVariable int pageNo, @PathVariable int pageSize) {
        return ResponseEntity.ok(taskService.getTaskPagination(pageSize, pageNo));
    }
    
    @PutMapping("/{id}")
        public ResponseEntity<TaskDTO> updateTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
        TaskDTO checkDTO = taskService.getById(id);
        if (checkDTO != null)
            return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
        else
            return new ResponseEntity<TaskDTO>(new TaskDTO(), HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("/{id}")
       public ResponseEntity<TaskDTO> deleteTask(@PathVariable("id")String id)
   {
       return new ResponseEntity<TaskDTO>(taskService.deleteById(id),HttpStatus.NO_CONTENT);
   }
}
