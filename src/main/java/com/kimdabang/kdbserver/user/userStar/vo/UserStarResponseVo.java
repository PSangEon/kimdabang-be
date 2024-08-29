package com.kimdabang.kdbserver.user.userStar.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStarResponseVo {
    private Date expirationDate;
    private Date createdAt;
    private Boolean isEcho;
}
