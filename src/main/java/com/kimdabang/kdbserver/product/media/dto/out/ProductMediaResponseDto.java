package com.kimdabang.kdbserver.product.media.dto.out;

import com.kimdabang.kdbserver.product.media.vo.ProductMediaResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductMediaResponseDto {

    private Long id;
    private Long productId;
    private String mediaName;
    private String mediaType;
    private String mediaURL;

    private ProductMediaResponseVo toProductMediaResponseVo() {
        return ProductMediaResponseVo.builder()
                .id(id)
                .productId(productId)
                .mediaName(mediaName)
                .mediaType(mediaType)
                .mediaURL(mediaURL)
                .build();
    }

    @Builder
    public ProductMediaResponseDto(Long id, Long productId, String mediaName, String mediaType, String mediaURL) {
        this.id = id;
        this.productId = productId;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
        this.mediaURL = mediaURL;

    }
}
