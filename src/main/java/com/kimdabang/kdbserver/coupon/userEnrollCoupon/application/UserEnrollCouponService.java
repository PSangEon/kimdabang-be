package com.kimdabang.kdbserver.coupon.userEnrollCoupon.application;

import com.kimdabang.kdbserver.coupon.userEnrollCoupon.dto.in.UserEnrollCouponAddRequestDto;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.dto.in.UserEnrollCouponRequestDto;
import com.kimdabang.kdbserver.coupon.userEnrollCoupon.dto.out.UserEnrollCouponResponseDto;

import java.util.List;

public interface UserEnrollCouponService {

    void addUserEnrollCoupon(UserEnrollCouponAddRequestDto userEnrollCouponAddRequestDto);
    void updateUserEnrollCoupon(UserEnrollCouponRequestDto userEnrollCouponRequestDto);
    void deleteUserEnrollCoupon(Long id);
    UserEnrollCouponResponseDto getOneUserEnrollCoupon(Long id);
    List<UserEnrollCouponResponseDto> getAllUserEnrollCoupon();
}
