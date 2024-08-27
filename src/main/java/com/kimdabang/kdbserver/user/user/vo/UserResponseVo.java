package com.kimdabang.kdbserver.user.user.vo;

import com.kimdabang.kdbserver.user.user.domain.Gender;
import com.kimdabang.kdbserver.user.user.domain.Grade;
import lombok.*;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseVo {

    private Long id;
    private String UUID;
    private String loginId;
    private String password;
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
