package com.kimdabang.kdbserver.coupon.userEnrollCoupon.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.application.UserEnrollCouponService;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.dto.in.UserEnrollCouponAddRequestDto;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.vo.UserEnrollCouponRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user-enroll-coupon")
public class UserEnrollCouponController {

    private final UserEnrollCouponService userEnrollCouponService;

    @PostMapping
    public CommonResponseEntity<Void> createUserEnrollCoupon(@RequestBody UserEnrollCouponRequestVo userEnrollCouponRequestVo) {
        log.info("userEnrollCouponRequestVo = {}", userEnrollCouponRequestVo);
        UserEnrollCouponAddRequestDto userEnrollCouponAddRequestDto = UserEnrollCouponAddRequestDto.builder()
                .accessToken(userEnrollCouponRequestVo.getAccessToken())
                .couponId(userEnrollCouponRequestVo.getCouponId())
                .createdAt(userEnrollCouponRequestVo.getCreatedAt())
                .isUsed(userEnrollCouponRequestVo.getIsUsed())
                .usedAt(userEnrollCouponRequestVo.getUsedAt())
                .expiredDate(userEnrollCouponRequestVo.getExpiredDate())
                .build();
        userEnrollCouponService.addUserEnrollCoupon(userEnrollCouponAddRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "유저 쿠폰 등록 성공",
                null
                );
    }
}
