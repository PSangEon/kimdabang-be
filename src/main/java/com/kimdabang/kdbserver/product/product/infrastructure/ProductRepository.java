package com.kimdabang.kdbserver.product.product.infrastructure;

import com.kimdabang.kdbserver.product.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long productId);
    Optional<Product> findByProductCode(String productCode);
}
