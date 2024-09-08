package com.kimdabang.kdbserver.notification.notification.infrastructure;

import com.kimdabang.kdbserver.notification.notification.domain.Notification;

import java.util.Date;
import java.util.List;

public interface NotificationRepositoryCustom {

    List<Notification> getNotificationWithDate(Date start, Date end);
}
