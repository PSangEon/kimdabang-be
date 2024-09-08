package com.kimdabang.kdbserver.notification.notification.application;

import com.kimdabang.kdbserver.notification.notification.domain.Notification;
import com.kimdabang.kdbserver.notification.notification.dto.out.NotificationResponseDto;
import com.kimdabang.kdbserver.notification.notification.infrastructure.NotificationRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepositoryCustom notificationRepositoryCustom;

    public List<NotificationResponseDto> getNotification(Date start, Date end) {
        List<Notification> notificationList = notificationRepositoryCustom.getNotificationWithDate(start, end);
        log.info("notificationList: {}", notificationList);
        if (notificationList != null) {

            return notificationList.stream()
                    .map(notification -> {
                        return NotificationResponseDto.builder()
                                .title(notification.getTitle())
                                .activeDate(notification.getActiveDate())
                                .expireDate(notification.getExpireDate())
                                .description(notification.getDescription())
                                .build();
                    })
                    .toList();
        }
        return List.of();
    }

}
