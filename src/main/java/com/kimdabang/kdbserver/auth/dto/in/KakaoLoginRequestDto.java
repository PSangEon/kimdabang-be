package com.kimdabang.kdbserver.auth.dto.in;

import com.kimdabang.kdbserver.auth.vo.in.KakaoLoginRequestVo;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class KakaoLoginRequestDto {
    private String providerAccountId;

    public KakaoLoginRequestDto toEntity(KakaoLoginRequestVo kakaoLoginRequestVo) {
        return KakaoLoginRequestDto.builder()
                .providerAccountId(kakaoLoginRequestVo.getProviderAccountId())
                .build();
    }
}
