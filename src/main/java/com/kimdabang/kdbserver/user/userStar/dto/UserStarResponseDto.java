package com.kimdabang.kdbserver.user.userStar.dto;

import com.kimdabang.kdbserver.user.userStar.vo.UserStarResponseVo;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStarResponseDto {
    private Date expirationDate;
    private Date createdAt;
    private String description;
    private Boolean isEcho;
    private Integer starAmount;

    public UserStarResponseVo toResponseVo() {
        return UserStarResponseVo.builder()
                .expirationDate(expirationDate)
                .createdAt(createdAt)
                .description(description)
                .isEcho(isEcho)
                .starAmount(starAmount)
                .build();
    }
}
