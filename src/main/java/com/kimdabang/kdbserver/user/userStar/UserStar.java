package com.kimdabang.kdbserver.user.userStar;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Getter
@Entity
public class UserStar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("유효기간")
    @Column(nullable = false, length = 20)
    private Date expirationDate;

    @Comment("적립일자")
    @Column(nullable = false, length = 20)
    private Date createdAt;

    @Comment("애코별 여뷰")
    @Column(nullable = false)
    private Boolean isEcho;

    //todo 릴레이션 붙은 유저 ID추가
}
