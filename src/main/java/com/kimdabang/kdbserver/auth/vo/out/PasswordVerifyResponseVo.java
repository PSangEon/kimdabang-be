package com.kimdabang.kdbserver.auth.vo.out;

import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVerifyResponseVo {
    private Boolean Verification;
}
