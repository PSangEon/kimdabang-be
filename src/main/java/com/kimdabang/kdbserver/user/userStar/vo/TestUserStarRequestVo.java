package com.kimdabang.kdbserver.user.userStar.vo;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.util.Date;

@ToString
@Getter
public class TestUserStarRequestVo {
    private Date expirationDate;
    private String accesstoken;
    private Boolean isEcho;
}
