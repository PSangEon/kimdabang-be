package com.kimdabang.kdbserver.auth.application;

import com.kimdabang.kdbserver.auth.dto.*;

public interface AuthService {

    void signUp(SignUpRequestDto signUpRequestDto);
    SignInResponseDto signIn(SignInRequestDto signInRequestDto);
    TestTokenResponseDto testToken(TestTokenRequestDto testTokenRequestDto);
}
