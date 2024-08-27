package com.kimdabang.kdbserver.auth.application;

import com.kimdabang.kdbserver.auth.dto.SignInRequestDto;
import com.kimdabang.kdbserver.auth.dto.SignInResponseDto;
import com.kimdabang.kdbserver.auth.dto.SignUpRequestDto;

public interface AuthService {

    void signUp(SignUpRequestDto signUpRequestDto);
    SignInResponseDto signIn(SignInRequestDto signInRequestDto);

}
