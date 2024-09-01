package com.kimdabang.kdbserver.auth.vo;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseVo {

    private String accessToken;
//    private String refreshToken;
//    private String name;
//    private UUID uuid;

}
