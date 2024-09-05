package com.kimdabang.kdbserver.favorite.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteResponseVo {

    private Long id;
    private String productCode;
    private String userUuid;
    private Boolean isCanceled;

}
