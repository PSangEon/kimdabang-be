package com.kimdabang.kdbserver.restock.infrastructure;

import com.kimdabang.kdbserver.restock.domain.QRestock;
import com.kimdabang.kdbserver.restock.domain.Restock;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RestockRepositoryImpl implements RestockRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Restock> getRestockWithProductCode(String uuid, String productCode) {
        QRestock restock = QRestock.restock;

        return jpaQueryFactory.selectFrom(restock)
                .where(restock.productCode.eq(productCode).and(restock.uuid.eq(uuid))).stream().findFirst();
    }
}
