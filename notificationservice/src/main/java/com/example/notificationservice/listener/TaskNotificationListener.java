package com.example.notificationservice.listener;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.notificationservice.dto.TaskNotificationDTO;
import com.example.notificationservice.entities.Notification;
import com.example.notificationservice.repositories.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskNotificationListener {
    private final NotificationRepository notificationRepository;
    @RabbitListener(queues = "myqueue")
    public void handleMessage(String message) throws JsonProcessingException{
        TaskNotificationDTO taskNotificationDTO=new ObjectMapper().readValue(message,TaskNotificationDTO.class);
        Notification notification=new Notification();
        notification.setTaskDescription(taskNotificationDTO.getTaskId());
        notification.setTaskTitle(taskNotificationDTO.getTaskTitle());
        notification.setEmployeeId(taskNotificationDTO.getEmployeeId());
        notification.setTaskId(taskNotificationDTO.getTaskId());
        notificationRepository.save(notification);
        System.out.println("Message received from Task Service");
        System.out.println(taskNotificationDTO.toString());
    }
}
