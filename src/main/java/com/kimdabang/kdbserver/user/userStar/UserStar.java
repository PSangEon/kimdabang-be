package com.kimdabang.kdbserver.user.userStar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.util.Date;

@Getter
@Entity
public class UserStar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Comment("유효기간")
    private Date expirationDate;

    @Comment("적립일자")
    private Date createdAt;

    @Comment("애코별 여뷰")
    private Boolean isEcho;

    //todo 릴레이션 붙은 유저 ID추가
}
