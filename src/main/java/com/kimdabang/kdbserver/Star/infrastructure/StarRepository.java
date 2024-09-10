package com.kimdabang.kdbserver.Star.infrastructure;

import com.kimdabang.kdbserver.Star.domain.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarRepository extends JpaRepository<Star, Long> {
    List<Star> findByUuid(String uuid);
    }
