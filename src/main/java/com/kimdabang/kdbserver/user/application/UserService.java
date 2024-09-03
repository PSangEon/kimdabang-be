package com.kimdabang.kdbserver.user.application;

import com.kimdabang.kdbserver.user.dto.UserResponseDto;
import com.kimdabang.kdbserver.user.dto.UserSignUpDto;

import java.util.UUID;

public interface UserService {

    void signUp(UserSignUpDto userSignUpDto);
    UserSignUpDto getUserById(Long id);
    UserSignUpDto getUserByEmail(String email);
    UserResponseDto getUserByUuid(String uuid);
}
