package com.kimdabang.kdbserver.auth.dto.in;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginIdFindReqiestDto {
    private String email;
}
