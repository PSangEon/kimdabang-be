package com.kimdabang.kdbserver.user.dto;

import com.kimdabang.kdbserver.user.domain.Gender;
import com.kimdabang.kdbserver.user.domain.Grade;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponseDto {
    private String loginId;
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private Boolean solar;
    private Date birth;
    private String nickname;
    private Grade grade;
    private String profileImg;

}
