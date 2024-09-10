package com.kimdabang.kdbserver.notification.infrastructure;

import com.kimdabang.kdbserver.notification.domain.Notification;

import java.util.Date;
import java.util.List;

public interface NotificationRepositoryCustom {

    List<Notification> getNotificationWithDate(Date start, Date end);
}
