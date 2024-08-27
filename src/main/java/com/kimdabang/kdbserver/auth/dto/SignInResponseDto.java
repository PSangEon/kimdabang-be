package com.kimdabang.kdbserver.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {

    private String accessToken;
//    private String refreshToken;
    private String name;
    private UUID uuid;

//    todo : to vo SignInResponseVo



}
