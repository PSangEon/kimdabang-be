package com.kimdabang.kdbserver.Star.dto.in;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarRequestDto {
    private Date startDate;
    private Date endDate;
    private String accessToken;
}
