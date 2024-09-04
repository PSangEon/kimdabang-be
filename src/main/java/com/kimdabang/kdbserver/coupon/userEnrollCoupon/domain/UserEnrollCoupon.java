package com.kimdabang.kdbserver.coupon.userEnrollCoupon.domain;

import com.kimdabang.kdbserver.common.entity.BaseEntity;
import com.kimdabang.kdbserver.coupon.coupon.domain.Coupon;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class UserEnrollCoupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고객 쿠폰 pk")
    private Long id;
    @Comment("고객 id")
    @Column(nullable = false)
    private String userUuid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    @Comment("사용 여부")
    @Column(nullable = false)
    private Boolean isUsed;
    @Comment("사용 일시")
    private LocalDateTime usedAt;
    @Comment("쿠폰 만료일")
    @Column(nullable = false)
    private LocalDateTime expiredDate;

    @Builder
    public UserEnrollCoupon(Long id, String userUuid, Coupon coupon, Boolean isUsed, LocalDateTime usedAt, LocalDateTime expiredDate) {
        this.id = id;
        this.userUuid = userUuid;
        this.coupon = coupon;
        this.isUsed = isUsed;
        this.usedAt = usedAt;
        this.expiredDate = expiredDate;
    }
}
