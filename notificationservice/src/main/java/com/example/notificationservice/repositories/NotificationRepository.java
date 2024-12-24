package com.example.notificationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notificationservice.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    
}
