package com.kimdabang.kdbserver.product.media.application;

import com.kimdabang.kdbserver.product.media.domain.ProductMedia;
import com.kimdabang.kdbserver.product.media.dto.in.ProductMediaRequestDto;
import com.kimdabang.kdbserver.product.media.dto.out.ProductMediaResponseDto;
import com.kimdabang.kdbserver.product.media.infrastructure.ProductMediaRepository;
import com.kimdabang.kdbserver.product.product.domain.Product;
import com.kimdabang.kdbserver.product.product.infrastructure.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void updateProductMedia(ProductMediaRequestDto productDto) {
        Product product = productRepository.findById(productDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + productDto.getProductId()));
        productMediaRepository.findByProductId(productDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 미디어가 존재하지 않습니다."));

        productMediaRepository.save(productDto.toProductMediaEntity(product));

    }

    @Override
    public void deleteProductMedia(String productMediaId) {
        Long longProductMediaId = Long.parseLong(productMediaId);
        ProductMedia deleteProductMedia = productMediaRepository.findById(longProductMediaId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 미디어가 존재하지 않습니다."));
        productMediaRepository.delete(deleteProductMedia);
    }

    @Override
    public ProductMediaResponseDto getProductMedia(String productMediaId) {
        Long longProductMediaId = Long.parseLong(productMediaId);
        ProductMedia getProductMedia = productMediaRepository.findById(longProductMediaId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품 미디어가 존재하지 않습니다."));

        return ProductMediaResponseDto.builder()
                .id(getProductMedia.getId())
                .productId(getProductMedia.getProduct().getId())
                .mediaName(getProductMedia.getMediaName())
                .mediaType(getProductMedia.getMediaType())
                .mediaURL(getProductMedia.getMediaURL())
                .build();
    }

    @Override
    public List<ProductMediaResponseDto> getAllProductMedia(String productId) {
        Long longProductId = Long.parseLong(productId);
        List<ProductMedia> productMediaList = productMediaRepository.findAllByProductId(longProductId);
        if (productMediaList != null) {
            return productMediaList.stream()
                    .map(productMedia -> ProductMediaResponseDto.builder()
                            .id(productMedia.getId())
                            .productId(longProductId)
                            .mediaName(productMedia.getMediaName())
                            .mediaType(productMedia.getMediaType())
                            .mediaURL(productMedia.getMediaURL())
                            .build())
                    .toList();
        }
        return List.of();
    }
}
