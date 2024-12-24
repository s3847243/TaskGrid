package com.example.notificationservice.api;

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

import com.example.notificationservice.dto.NotificationDTO;
import com.example.notificationservice.services.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
        private final NotificationService notificationService;
        @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getById(@PathVariable long id)
    {
        return ResponseEntity.ok(notificationService.getById(id));
    }
    @PostMapping
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO)
    {
        return new ResponseEntity<NotificationDTO>(notificationService.save(notificationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable long id,@RequestBody NotificationDTO notificationDTO)
    {
        return ResponseEntity.ok(notificationService.update(id,notificationDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<NotificationDTO> deleteNotification(@PathVariable long id)
    {
        return ResponseEntity.ok(notificationService.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllNotifications()
    {
        return ResponseEntity.ok(notificationService.getAll());
    }
    
}
