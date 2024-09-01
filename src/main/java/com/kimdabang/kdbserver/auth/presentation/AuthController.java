package com.kimdabang.kdbserver.auth.presentation;

import com.kimdabang.kdbserver.auth.application.AuthService;
import com.kimdabang.kdbserver.auth.dto.TestTokenRequestDto;
import com.kimdabang.kdbserver.auth.dto.SignInRequestDto;
import com.kimdabang.kdbserver.auth.dto.SignUpRequestDto;
import com.kimdabang.kdbserver.auth.vo.*;
import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "SignIn API", description = "SignIn API 입니다.", tags = {"Auth"})
    @PostMapping("/sign-in")
    public CommonResponseEntity<SignInResponseVo> signIn(
            @RequestBody SignInRequestVo signInRequestVo) {
        ModelMapper modelMapper = new ModelMapper();
        SignInRequestDto signInRequestDto = SignInRequestDto.builder().
                loginId(signInRequestVo.getLoginId()).
                password(signInRequestVo.getPassword()).
                build();
        SignInResponseVo signInResponseVo = modelMapper.map(authService.signIn(signInRequestDto), SignInResponseVo.class);
        log.info("signInResponseVo : {}", signInResponseVo);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                signInResponseVo);

    }

    @Operation(summary = "SignUp API", description = "SignUp API 입니다.", tags = {"Auth"})
    @PostMapping("/sign-up")
    public CommonResponseEntity<Void> signUp(
            @RequestBody SignUpRequestVo signUpRequestVo) {
        authService.signUp(new ModelMapper().map(signUpRequestVo, SignUpRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }


    @Operation(summary = "TestToken API", description = "토큰 테스트 API 입니다.", tags = {"Auth"})
    @PostMapping("/token-test")
    public CommonResponseEntity<TestTokenResponseVo> testToken(
            @RequestBody TestTokenRequestVo testTokenRequestVo) {
        ModelMapper modelMapper = new ModelMapper();
        TestTokenRequestDto testTokenRequestDto = TestTokenRequestDto.builder().
                accessToken(testTokenRequestVo.getAccessToken()).
                build();
        TestTokenResponseVo testTokenResponseVo = modelMapper.map(authService.testToken(testTokenRequestDto), TestTokenResponseVo.class);
        log.info("accessResponseVo : {}", testTokenResponseVo);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                testTokenResponseVo);
    }
}
