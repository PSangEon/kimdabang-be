package com.kimdabang.kdbserver.product.media.application;

import com.kimdabang.kdbserver.product.media.dto.in.ProductMediaRequestDto;
import com.kimdabang.kdbserver.product.media.infrastructure.ProductMediaRepository;
import com.kimdabang.kdbserver.product.product.domain.Product;
import com.kimdabang.kdbserver.product.product.infrastructure.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductMediaServiceImpl implements ProductMediaService {

    private final ProductMediaRepository productMediaRepository;
    private final ProductRepository productRepository;

    @Override
    public void addProductMedia(ProductMediaRequestDto productDto) {
        Product product = productRepository.findById(productDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + productDto.getProductId()));

        productMediaRepository.save(productDto.toProductMediaEntity(product));
    }
}
