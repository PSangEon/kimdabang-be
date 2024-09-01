package com.kimdabang.kdbserver.user.userAddress.infrastructure;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.QUserAddress;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UserAddressRepositoryImpl implements UserAddressRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<UserAddress> getUserAddressWithUser(User user){
        QUserAddress userAddress = QUserAddress.userAddress;
        log.info("user:{}",user);
        return jpaQueryFactory.selectFrom(userAddress)
                .where(userAddress.user.eq(user))
                .fetch();
    }
}
