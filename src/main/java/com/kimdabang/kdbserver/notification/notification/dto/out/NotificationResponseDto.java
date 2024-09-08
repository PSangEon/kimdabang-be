package com.kimdabang.kdbserver.notification.notification.dto.out;

import com.kimdabang.kdbserver.notification.notification.vo.out.NotificationResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponseDto {

    private String title;
    private Date activeDate;
    private Date expireDate;
    private String description;

    public NotificationResponseVo toResponseVo() {
        return NotificationResponseVo.builder()
                .title(title)
                .activeDate(activeDate)
                .expireDate(expireDate)
                .description(description)
                .build();
    }
}
