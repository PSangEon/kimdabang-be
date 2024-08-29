package com.kimdabang.kdbserver.user.userStar.infrastructure;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userStar.domain.UserStar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserStarRepository extends JpaRepository<UserStar, Long> {
    Optional<UserStar> findByUuid(UUID uuid);
}
