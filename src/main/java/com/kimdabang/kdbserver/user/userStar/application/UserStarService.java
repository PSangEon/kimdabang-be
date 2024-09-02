package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.user.userStar.dto.UserStarAddRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;

import java.util.Date;
import java.util.List;

public interface UserStarService {
    List<UserStarResponseDto> getUserStar(Date start, Date end, String Authorization);
    void addUserStar(UserStarAddRequestDto userStarAddRequestDto);
}
