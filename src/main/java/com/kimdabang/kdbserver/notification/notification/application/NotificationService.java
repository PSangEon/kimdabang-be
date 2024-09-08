package com.kimdabang.kdbserver.notification.notification.application;

import com.kimdabang.kdbserver.notification.notification.dto.out.NotificationResponseDto;

import java.util.Date;
import java.util.List;

public interface NotificationService {
    List<NotificationResponseDto> getNotification(Date start, Date end);
}
