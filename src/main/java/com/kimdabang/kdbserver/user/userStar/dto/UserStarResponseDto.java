package com.kimdabang.kdbserver.user.userStar.dto;

import com.kimdabang.kdbserver.user.userStar.vo.UserStarResponseVo;
import lombok.*;

import java.util.Date;
import java.util.Objects;

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

    //중복 체크를 특정 갑으로 하기 위해 추가
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserStarResponseDto that = (UserStarResponseDto) o;
        return isEcho == that.isEcho &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, createdAt, isEcho);
    }
}
