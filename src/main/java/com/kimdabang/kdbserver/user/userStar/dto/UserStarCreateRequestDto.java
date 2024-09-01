package com.kimdabang.kdbserver.user.userStar.dto;

import com.kimdabang.kdbserver.user.userStar.domain.UserStar;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStarCreateRequestDto {
    private String accesstoken;
    private Date expirationDate;
    private String description;
    private Boolean isEcho;
    private Integer starAmount;

    public UserStar toEntity(UUID uuid ,Date createdAt) {
        Date now = new Date();
        return UserStar.builder()
                .uuid(uuid)
                .expirationDate(expirationDate)
                //.createdAt(new Date(now.getTime()))
                .createdAt(createdAt)
                .isEcho(isEcho)
                .isUsed(false)
                .description(description)
                .build();
    }
}
