package com.example.taskservice.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.taskservice.dto.TaskNotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskNotificationProducer {
    @Value("${ms.rabbit.routing.name}")
    private String routingName;
    @Value("${ms.rabbit.exchange.name}")
    private String exchangeName;

    private final AmqpTemplate amqpTemplate;
    public void sendToQueue(TaskNotificationDTO taskNotificationDTO) throws JsonProcessingException {
        String taskString=new ObjectMapper().writeValueAsString(taskNotificationDTO);
        System.out.println("Notification Sent: "+ taskNotificationDTO.toString());
        amqpTemplate.convertAndSend(exchangeName,routingName,taskString);

    }
}
