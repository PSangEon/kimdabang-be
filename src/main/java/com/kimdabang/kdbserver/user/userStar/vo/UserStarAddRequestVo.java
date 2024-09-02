package com.kimdabang.kdbserver.user.userStar.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class UserStarAddRequestVo {
    private String accesstoken;
    private Date expirationDate;
    private String description;
    private Boolean isEcho;
    private Integer starAmount;
}
