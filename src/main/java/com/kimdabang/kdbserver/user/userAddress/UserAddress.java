package com.kimdabang.kdbserver.user.userAddress;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("배송지")
    @Column(nullable = false, length = 100)
    private String address;

    @Comment("기본 배송지 여부")
    @Column(nullable = false)
    private Boolean isDefault;

    @Comment("주소 별칭")
    @Column(nullable = false, length = 100)
    private String addressName;

    //todo 릴레이션 붙은 유저 ID추가


}
