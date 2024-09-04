package com.kimdabang.kdbserver.auth.dto.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PasswordRequestDto {
    private String accessToken;
    private String password;
}
