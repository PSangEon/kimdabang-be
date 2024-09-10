package com.kimdabang.kdbserver.auth.vo.in;

import com.kimdabang.kdbserver.user.domain.Gender;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class SignUpRequestVo {

    private String loginId;
    private String password;
    private String kakaoId;
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private Boolean solar;
    private Date birth;
    private String nickname;
}
