package com.kimdabang.kdbserver.notification.infrastructure;

import com.kimdabang.kdbserver.notification.domain.Notification;
import com.kimdabang.kdbserver.notification.domain.QNotification;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class NotificationRepositoryCustomImpl implements NotificationRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Notification> getNotificationWithDate(Date start, Date end) {
        QNotification qNotification = QNotification.notification;

        return jpaQueryFactory.selectFrom(qNotification)
                .where(qNotification.expireDate.between(start, end))
                .fetch();
    }

}
