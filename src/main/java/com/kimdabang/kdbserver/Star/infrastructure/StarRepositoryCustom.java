package com.kimdabang.kdbserver.Star.infrastructure;

import com.kimdabang.kdbserver.Star.domain.Star;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface StarRepositoryCustom {
    List<Star> getUserStarWithDate(UUID uuid, Date start, Date end);
}
