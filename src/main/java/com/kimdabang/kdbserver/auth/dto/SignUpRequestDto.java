package com.kimdabang.kdbserver.auth.dto;

import com.kimdabang.kdbserver.user.user.domain.Gender;
import com.kimdabang.kdbserver.user.user.domain.Grade;
import com.kimdabang.kdbserver.user.user.domain.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SignUpRequestDto {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private Boolean solar;
    private Date birth;
    private String nickname;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .loginId(loginId)
                .uuid(UUID.randomUUID())
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .phone(phone)
                .gender(gender)
                .solar(solar)
                .birth(birth)
                .nickname(nickname)
                .grade(Grade.GRADE_WELCOME)
                .profileImg("기본이미지URL")
                .build();
    }

}
