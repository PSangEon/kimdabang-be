package com.kimdabang.kdbserver.Star.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarRequestDto {
    private Date startDate;
    private Date endDate;
    private String accessToken;
}
