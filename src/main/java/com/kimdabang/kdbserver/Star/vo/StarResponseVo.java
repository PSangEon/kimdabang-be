package com.kimdabang.kdbserver.Star.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarResponseVo {
    private Date expirationDate;
    private Date createdAt;
    private Boolean isEcho;
    private Integer starAmount;
    private String description;
}
