package com.kimdabang.kdbserver.coupon.userEnrollCoupon.dto.in;

import com.kimdabang.kdbserver.coupon.coupon.domain.Coupon;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.domain.UserEnrollCoupon;
import lombok.Builder;

import java.time.LocalDateTime;

public class UserEnrollCouponRequestDto {
    private Long id;
    private String userUuid;
    private Coupon coupon;
    private Boolean isUsed;
    private LocalDateTime usedAt;
    private LocalDateTime expiredDate;

    public UserEnrollCoupon toEntity() {
        return UserEnrollCoupon.builder()
                .id(id)
//                .userUuid(userUuid)
                .coupon(coupon)
                .isUsed(isUsed)
                .usedAt(usedAt)
                .expiredDate(expiredDate)
                .build();
    }

    @Builder
    public UserEnrollCouponRequestDto(Long id, String userUuid, Coupon coupon, Boolean isUsed, LocalDateTime usedAt, LocalDateTime expiredDate) {
        this.id = id;
        this.userUuid = userUuid;
        this.coupon = coupon;
        this.isUsed = isUsed;
        this.usedAt = usedAt;
        this.expiredDate = expiredDate;
    }

}
