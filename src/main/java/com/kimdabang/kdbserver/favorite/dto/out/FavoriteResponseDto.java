package com.kimdabang.kdbserver.favorite.dto.out;

import com.kimdabang.kdbserver.favorite.vo.FavoriteResponseVo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FavoriteResponseDto {

    private Long id;
    private String productCode;
    private String userUuid;
    private boolean isCanceled;

    public FavoriteResponseVo toFavoriteResponseVo() {
        return FavoriteResponseVo.builder()
                .id(id)
                .productCode(productCode)
                .userUuid(userUuid)
                .isCanceled(isCanceled)
                .build();
    }

    @Builder
    public FavoriteResponseDto(Long id, String productCode, String userUuid, boolean isCanceled) {

        this.id = id;
        this.productCode = productCode;
        this.userUuid = userUuid;
        this.isCanceled = isCanceled;
    }
}
