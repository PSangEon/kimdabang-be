package com.kimdabang.kdbserver.auth.vo.in;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class KakaoLoginRequestVo {
    private String providerAccountId;
}
