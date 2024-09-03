package com.kimdabang.kdbserver.Address.infrastructure;

import com.kimdabang.kdbserver.Address.domain.Address;
import com.kimdabang.kdbserver.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.QUserAddress;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Address> getUserAddressWithUser(User user){
        QUserAddress userAddress = QUserAddress.userAddress;
        log.info("user:{}",user);
        return jpaQueryFactory.selectFrom(userAddress)
                .where(userAddress.user.eq(user))
                .fetch();
    }
    public Optional<Address> findByUserAddressIdWithUser(Long id, User user){
        QUserAddress userAddress = QUserAddress.userAddress;
        log.info("user:{}",user);
        return jpaQueryFactory.selectFrom(userAddress)
                .where(userAddress.id.eq(id).and(userAddress.user.eq(user))).stream().findFirst();
    }
}
