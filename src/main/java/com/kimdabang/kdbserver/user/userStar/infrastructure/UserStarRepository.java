package com.kimdabang.kdbserver.user.userStar.infrastructure;

import com.kimdabang.kdbserver.user.userStar.domain.UserStar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserStarRepository extends JpaRepository<UserStar, Long> {
    List<UserStar> findByUuid(UUID uuid);
}
