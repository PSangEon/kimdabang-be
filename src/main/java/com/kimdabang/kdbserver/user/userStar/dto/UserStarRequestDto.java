package com.kimdabang.kdbserver.user.userStar.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStarRequestDto {
    private Date startDate;
    private Date endDate;
    private String accessToken;
}
