package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.user.userStar.dto.UserStarCreateRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;

import java.util.List;

public interface UserStarService {
    List<UserStarResponseDto> getUserStar(UserStarRequestDto userStarRequestDto);
    void createUserStar(UserStarCreateRequestDto userStarCreateRequestDto);
}
