package com.kimdabang.kdbserver.product.product.infrastructure;

import com.kimdabang.kdbserver.product.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Optional<Product> findByProductId(Long productId);
    Optional<Product> findByProductCode(String productCode);
}
