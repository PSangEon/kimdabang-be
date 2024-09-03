package com.kimdabang.kdbserver.Star.dto;

import com.kimdabang.kdbserver.Star.domain.Star;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarAddRequestDto {
    private String accesstoken;
    private Date expirationDate;
    private String description;
    private Boolean isEcho;
    private Integer starAmount;

    public Star toEntity(UUID uuid , Date createdAt) {
        Date now = new Date();
        return Star.builder()
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
