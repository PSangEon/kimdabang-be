package com.kimdabang.kdbserver.auth.application;

import com.kimdabang.kdbserver.auth.dto.in.*;
import com.kimdabang.kdbserver.auth.dto.out.LoginIdFindResponseDto;
import com.kimdabang.kdbserver.auth.dto.out.PasswordVerifyResponseDto;
import com.kimdabang.kdbserver.auth.dto.out.SignInResponseDto;
import com.kimdabang.kdbserver.auth.dto.out.TestTokenResponseDto;

public interface AuthService {

    void signUp(SignUpRequestDto signUpRequestDto);
    SignInResponseDto signIn(SignInRequestDto signInRequestDto);
    TestTokenResponseDto testToken(TestTokenRequestDto testTokenRequestDto);
    void putPassword(PasswordRequestDto passwordRequestDto);
    PasswordVerifyResponseDto verifyPassword(PasswordRequestDto passwordRequestDto);
    LoginIdFindResponseDto findEmail(LoginIdFindReqiestDto loginIdFindReqiestDto);
}
