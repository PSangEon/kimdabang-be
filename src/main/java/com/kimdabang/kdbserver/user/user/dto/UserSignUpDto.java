package com.kimdabang.kdbserver.user.user.dto;

import com.kimdabang.kdbserver.user.user.domain.Gender;
import com.kimdabang.kdbserver.user.user.domain.Grade;
import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.user.vo.UserResponseVo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserSignUpDto {

    private Long id;
    private UUID uuid;
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

    public User toEntity() {
        return User.builder()
                .id(id)
                .uuid(uuid)
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .phone(phone)
                .gender(gender)
                .solar(solar)
                .birth(birth)
                .nickname(nickname)
                .grade(grade)
                .profileImg(profileImg)
                .build();
    }

    public UserResponseVo toResponseVo() {
        return UserResponseVo.builder()
                .id(id)
                .uuid(uuid)
                .loginId(loginId)
                .password(password)
                .name(name)
                .email(email)
                .phone(phone)
                .gender(gender)
                .solar(solar)
                .birth(birth)
                .nickname(nickname)
                .grade(grade)
                .profileImg(profileImg)
                .build();
    }
}
