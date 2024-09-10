package com.kimdabang.kdbserver.restock.infrastructure;

import com.kimdabang.kdbserver.restock.domain.Restock;

import java.util.Optional;

public interface RestockRepositoryCustom {
    Optional<Restock> getRestockWithProductCode(String uuid, String productCode);
}
