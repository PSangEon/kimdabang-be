package com.kimdabang.kdbserver.user.userStar.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.util.Date;
import java.util.UUID;

@Getter
@Entity
@ToString
@NoArgsConstructor
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

    @Comment("애코별 여부")
    @Column(nullable = false)
    private Boolean isEcho;

    @Comment("고객 UUID")
    @Column(columnDefinition = "BINARY(16)",nullable = false, updatable = false)
    private UUID uuid;

    @Comment("사용 여부")
    @Column(nullable = false)
    private Boolean isUsed;

    @Comment("사용 일자")
    @Column(nullable = true)
    private Date usedAt;

    @Builder
    public UserStar(
            Long id,
            Date expirationDate,
            Date createdAt,
            Boolean isEcho,
            UUID uuid,
            Boolean isUsed,
            Date usedAt

    ) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
        this.isEcho = isEcho;
        this.uuid = uuid;
        this.isUsed = isUsed;
        this.usedAt = usedAt;
    }
}

