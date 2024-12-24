package com.example.notificationservice.services;

import java.util.List;

import com.example.notificationservice.dto.NotificationDTO;

public interface NotificationService {
    public NotificationDTO save( NotificationDTO notificationDTO);
    public NotificationDTO getById(long Id);
    public List<NotificationDTO> getAll();
    public NotificationDTO update(long Id,NotificationDTO notificationDTO);
    public NotificationDTO delete(long Id);
}
