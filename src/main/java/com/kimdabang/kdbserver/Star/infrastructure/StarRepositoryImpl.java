package com.kimdabang.kdbserver.Star.infrastructure;

import com.kimdabang.kdbserver.user.userStar.domain.QUserStar;
import com.kimdabang.kdbserver.Star.domain.Star;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class StarRepositoryImpl implements StarRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Star> getUserStarWithDate(UUID uuid, Date start, Date end) {
        QUserStar userStar = QUserStar.userStar;

        return jpaQueryFactory.selectFrom(userStar)
                .where(userStar.createdAt.between(start, end).and(userStar.uuid.eq(uuid)))  // uuid 조건 추가
                .fetch();
    }
}
