package com.kimdabang.kdbserver.user.userStar.vo;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class UserStarRequestVo {
    private Date startDate;
    private Date endDate;
    private String accessToken;
}
