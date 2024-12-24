package com.example.taskservice.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.taskservice.entities.TaskDetail;
@Repository
public interface TaskDetailRepository extends ElasticsearchRepository<TaskDetail,String>  {
    public List<TaskDetail> findByTaskDescriptionContains(String description);
    public List<TaskDetail> findTaskDetailByEmployeeNameStartingWith(String text);
}
