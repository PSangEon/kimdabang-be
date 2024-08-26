package com.kimdabang.kdbserver.user.userAddress;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Comment("배송지")
    private String address;

    @Comment("기본 배송지 여부")
    private Boolean isDefault;

    @Comment("주소 별칭")
    private String addressName;

    //todo 릴레이션 붙은 유저 ID추가


}
