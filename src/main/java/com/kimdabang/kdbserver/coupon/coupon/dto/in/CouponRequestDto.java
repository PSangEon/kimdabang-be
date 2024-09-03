package com.kimdabang.kdbserver.coupon.coupon.dto.in;

import com.kimdabang.kdbserver.coupon.coupon.domain.Coupon;
import com.kimdabang.kdbserver.coupon.coupon.domain.CouponType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;

@Getter
public class CouponRequestDto {

    private Long id;
    private String name;
    private CouponType couponType;
    private LocalDateTime expiredDate;
    private int value;

    public Coupon toEntity() {
        return Coupon.builder()
                .id(id)
                .name(name)
                .couponType(couponType)
                .expiredDate(expiredDate)
                .value(value)
                .build();
    }

    @Builder
    public CouponRequestDto(Long id, String name, CouponType couponType, LocalDateTime expiredDate, int value) {
        this.id = id;
        this.name = name;
        this.couponType = couponType;
        this.expiredDate = expiredDate;
        this.value = value;
    }
}
