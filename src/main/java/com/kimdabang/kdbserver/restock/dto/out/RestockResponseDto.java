package com.kimdabang.kdbserver.restock.dto.out;

import com.kimdabang.kdbserver.restock.vo.out.RestockResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestockResponseDto {

    private Date restockDate;
    private Boolean status;
    private String productCode;
    private Date calledDate;

    public RestockResponseVo toResponseVo() {
        return RestockResponseVo.builder()
                .restockDate(restockDate)
                .status(status)
                .productCode(productCode)
                .calledDate(calledDate)
                .build();
    }
}
