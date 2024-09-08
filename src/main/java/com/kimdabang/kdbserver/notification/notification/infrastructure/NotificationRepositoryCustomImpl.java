package com.kimdabang.kdbserver.notification.notification.infrastructure;

import com.kimdabang.kdbserver.notification.notification.domain.Notification;
import com.kimdabang.kdbserver.notification.notification.domain.QNotification;
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
        QNotification notifiaction = QNotification.notification;

        return jpaQueryFactory.selectFrom(notifiaction)
                .where(notifiaction.expireDate.between(start, end))
                .fetch();
    }

}
