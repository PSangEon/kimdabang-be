package com.kimdabang.kdbserver.auth.vo.in;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PasswordRequestVo {
    private String accessToken;
    private String password;
}
