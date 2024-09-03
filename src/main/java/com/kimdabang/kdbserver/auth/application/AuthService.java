package com.kimdabang.kdbserver.auth.application;

import com.kimdabang.kdbserver.auth.dto.in.PasswordRequestDto;
import com.kimdabang.kdbserver.auth.dto.in.SignInRequestDto;
import com.kimdabang.kdbserver.auth.dto.in.SignUpRequestDto;
import com.kimdabang.kdbserver.auth.dto.in.TestTokenRequestDto;
import com.kimdabang.kdbserver.auth.dto.out.PasswordVerifyResponseDto;
import com.kimdabang.kdbserver.auth.dto.out.SignInResponseDto;
import com.kimdabang.kdbserver.auth.dto.out.TestTokenResponseDto;

public interface AuthService {

    void signUp(SignUpRequestDto signUpRequestDto);
    SignInResponseDto signIn(SignInRequestDto signInRequestDto);
    TestTokenResponseDto testToken(TestTokenRequestDto testTokenRequestDto);
    void putPassword(PasswordRequestDto passwordRequestDto);
    PasswordVerifyResponseDto verifyPassword(PasswordRequestDto passwordRequestDto);
}
