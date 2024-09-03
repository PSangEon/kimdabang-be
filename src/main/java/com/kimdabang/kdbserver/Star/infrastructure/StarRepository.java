package com.kimdabang.kdbserver.Star.infrastructure;

import com.kimdabang.kdbserver.Star.domain.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
    //List<UserStar> findByUuid(UUID uuid);
    }
