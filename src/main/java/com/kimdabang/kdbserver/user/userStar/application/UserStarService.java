package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.user.userStar.dto.TestUserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;

import java.util.List;

public interface UserStarService {
    UserStarResponseDto getUserStar(UserStarRequestDto userStarRequestDto);
    List<UserStarResponseDto> getUserStars(UserStarRequestDto userStarRequestDto);
    public void addUserStar(TestUserStarRequestDto testUserStarRequestDto);
}
