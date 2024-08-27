package com.kimdabang.kdbserver.user.user.application;

import com.kimdabang.kdbserver.user.user.dto.UserSignUpDto;

public interface UserService {

    void signUp(UserSignUpDto userSignUpDto);
    UserSignUpDto getUserById(Long id);
    UserSignUpDto getUserByEmail(String email);

}
