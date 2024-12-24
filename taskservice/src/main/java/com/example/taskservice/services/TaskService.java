package com.example.taskservice.services;

import java.util.List;

import com.example.taskservice.dto.TaskDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface TaskService {
    public TaskDTO saveTask(TaskDTO taskDTO)  throws JsonProcessingException;
    public TaskDTO updateTask(String id, TaskDTO taskDTO);
    public TaskDTO getById(String Id);
    public TaskDTO deleteById(String Id);

    public List<TaskDTO> getAllTasks();
    public List<TaskDTO> getTaskPagination(int pagesize, int pageno);
}
