package com.kimdabang.kdbserver.notification.infrastructure;

import com.kimdabang.kdbserver.Star.domain.Star;
import com.kimdabang.kdbserver.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findById(Long id);
}