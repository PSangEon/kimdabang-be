package com.kimdabang.kdbserver.coupon.userEnrollCoupon.infrastructure;

import com.kimdabang.kdbserver.coupon.userEnrollCoupon.domain.UserEnrollCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEnrollCouponRepository extends JpaRepository<UserEnrollCoupon, Long> {
}
