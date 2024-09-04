package com.kimdabang.kdbserver.auth.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVerifyResponseDto {
    private Boolean Verification;
}
