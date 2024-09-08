package com.kimdabang.kdbserver.notification.notification.infrastructure;

import com.kimdabang.kdbserver.Star.domain.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Star, Long> {
}
