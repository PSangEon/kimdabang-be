package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.user.userStar.dto.TestUserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;

import java.util.List;

public interface UserStarService {
    List<UserStarResponseDto> getUserStar(UserStarRequestDto userStarRequestDto);
    void addUserStar(TestUserStarRequestDto testUserStarRequestDto);
}
