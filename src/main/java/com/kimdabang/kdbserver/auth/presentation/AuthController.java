package com.kimdabang.kdbserver.auth.presentation;

import com.kimdabang.kdbserver.auth.application.AuthService;
import com.kimdabang.kdbserver.auth.dto.in.*;
import com.kimdabang.kdbserver.auth.vo.in.*;
import com.kimdabang.kdbserver.auth.vo.out.LoginIdFindResponseVo;
import com.kimdabang.kdbserver.auth.vo.out.PasswordVerifyResponseVo;
import com.kimdabang.kdbserver.auth.vo.out.SignInResponseVo;
import com.kimdabang.kdbserver.auth.vo.out.TestTokenResponseVo;
import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "login API", description = "login API 입니다.", tags = {"Auth"})
    @PostMapping("/login")
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

    @Operation(summary = "join API", description = "join API 입니다.", tags = {"Auth"})
    @PostMapping("/join")
    public CommonResponseEntity<Void> signUp(
            @RequestBody SignUpRequestVo signUpRequestVo) {
        authService.signUp(new ModelMapper().map(signUpRequestVo, SignUpRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @Operation(summary = "findid API", description = "findid API 입니다.", tags = {"Auth"})
    @PostMapping("/findid")
    public CommonResponseEntity<LoginIdFindResponseVo> findId(
            @RequestBody LoginIdFindReqiestVo loginIdFindReqiestVo) {
        ModelMapper modelMapper = new ModelMapper();
        LoginIdFindReqiestDto loginIdFindReqiestDto = LoginIdFindReqiestDto.builder().
                email(loginIdFindReqiestVo.getEmail()).
                build();
        LoginIdFindResponseVo loginIdFindResponseVo =modelMapper.map(authService.findEmail(loginIdFindReqiestDto), LoginIdFindResponseVo.class);
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), loginIdFindResponseVo);
    }

    @Operation(summary = "verifypassword API", description = "verifypassword API 입니다.", tags = {"Auth"})
    @PostMapping("/verifypassword")
    public CommonResponseEntity<PasswordVerifyResponseVo> verifyPassword(
            @RequestBody PasswordRequestVo passwordRequestVo) {
        ModelMapper modelMapper = new ModelMapper();
        PasswordRequestDto passwordRequestDto = new ModelMapper().map(passwordRequestVo, PasswordRequestDto.class);
        log.info("passwordRequestDto:{}",passwordRequestDto);
        PasswordVerifyResponseVo passwordVerifyResponseVo = modelMapper.map(authService.verifyPassword(passwordRequestDto), PasswordVerifyResponseVo.class);
        log.info("passwordVerifyResponseVo:{}",passwordVerifyResponseVo);
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), passwordVerifyResponseVo);
    }

    @Operation(summary = "putpassword API", description = "putpassword API 입니다.", tags = {"Auth"})
    @PostMapping("/putpassword")
    public CommonResponseEntity<Void> putPassword(
            @RequestBody PasswordRequestVo passwordRequestVo) {
        authService.putPassword(new ModelMapper().map(passwordRequestVo, PasswordRequestDto.class));
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
