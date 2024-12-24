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

import com.example.taskservice.dto.TaskDetailDTO;
import com.example.taskservice.services.TaskDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/taskdetail")
@RequiredArgsConstructor
public class TaskDetailController {
    private final TaskDetailService taskDetailService;
    @PostMapping
        public ResponseEntity<TaskDetailDTO> addTaskDetail(@RequestBody TaskDetailDTO taskDetailDTO)
    {
        return new ResponseEntity<TaskDetailDTO>(taskDetailService.save(taskDetailDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaskDetailDTO>> getAllTaskDetails()
    {
        return ResponseEntity.ok(taskDetailService.getAllTaskDetails());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> getTaskDetailbyId(@PathVariable("id")String id)
    {
        return ResponseEntity.ok(taskDetailService.getTaskDetailbyId(id));
    }
    @PutMapping("/{id}")
    //@CircuitBreaker(name = "TASK_SERVICE",fallbackMethod = "taskdetailservicefallback")
    public ResponseEntity<TaskDetailDTO> updateTaskDetail(@PathVariable String id,@RequestBody TaskDetailDTO taskDetailDTO)
    {
        TaskDetailDTO checkDTO=taskDetailService.getTaskDetailbyId(id);
        if(checkDTO!=null)
        {
            taskDetailDTO.setId(id);
            return ResponseEntity.ok(taskDetailService.updateTaskDetail(taskDetailDTO));
        }
        else
            return new ResponseEntity<TaskDetailDTO>(new TaskDetailDTO(),HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    //@CircuitBreaker(name = "TASK_SERVICE",fallbackMethod = "taskdetailservicefallback")
    public ResponseEntity<TaskDetailDTO> deleteTaskDetail(@PathVariable String id)
    {
        return ResponseEntity.ok(taskDetailService.deleteTaskDetail(id));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<TaskDetailDTO>> getByDescription(@PathVariable String description)
    {
        return ResponseEntity.ok(taskDetailService.getWithContainDescription(description));
    }
    @GetMapping("/name/{text}")
    public ResponseEntity<List<TaskDetailDTO>> getByStartswithname(@PathVariable String text)
    {
        return ResponseEntity.ok(taskDetailService.getWithStartsName(text));
    }
}
