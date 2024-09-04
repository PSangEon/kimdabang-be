package com.kimdabang.kdbserver.Star.dto.out;

import com.kimdabang.kdbserver.Star.vo.out.StarAmountResponseVo;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarAmountResponseDto {
    private Long starAmount;
    private Long greenStarAmount;

    public StarAmountResponseVo toResponseVo() {
        return StarAmountResponseVo.builder()
                .starAmount(starAmount)
                .greenStarAmount(greenStarAmount)
                .build();
    }
}
