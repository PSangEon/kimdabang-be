package com.kimdabang.kdbserver.user.userStar.infrastructure;

import com.kimdabang.kdbserver.user.userStar.domain.UserStar;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface UserStarRepositoryCustom {
    List<UserStar> getUserStarWithDate(UUID uuid, Date start, Date end);
}
