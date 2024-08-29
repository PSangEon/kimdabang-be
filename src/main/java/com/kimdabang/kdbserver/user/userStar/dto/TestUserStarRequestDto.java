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
public class TestUserStarRequestDto {
    private Date expirationDate;
    private String accesstoken;
    private Boolean isEcho;

    public UserStar toEntity(UUID uuid) {
        Date now = new Date();
        return UserStar.builder()
                .uuid(uuid)
                .expirationDate(expirationDate)
                .createdAt(new Date(now.getTime()))
                .isEcho(isEcho)
                .isUsed(false)
                .build();
    }
}
