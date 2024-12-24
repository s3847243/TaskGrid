package com.example.taskservice.services;

import java.util.List;

import com.example.taskservice.dto.TaskDetailDTO;

public interface TaskDetailService {
    public TaskDetailDTO save(TaskDetailDTO taskDetailDTO);
    public TaskDetailDTO getTaskDetailbyId(String Id);
    public List<TaskDetailDTO> getAllTaskDetails();
    public TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO);
    public TaskDetailDTO deleteTaskDetail(String Id);
    public List<TaskDetailDTO> getWithContainDescription(String description);
    public List<TaskDetailDTO> getWithStartsName(String text);
}
