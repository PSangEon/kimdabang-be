package com.kimdabang.kdbserver.auth.vo;

import com.kimdabang.kdbserver.user.user.domain.Gender;
import com.kimdabang.kdbserver.user.user.domain.Grade;
import com.kimdabang.kdbserver.user.user.domain.User;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class SignUpRequestVo {

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
