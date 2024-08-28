package com.kimdabang.kdbserver.auth.application;

import com.kimdabang.kdbserver.auth.dto.*;
import com.kimdabang.kdbserver.auth.infrastructure.AuthRepository;
import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {
        User user = authRepository.findByLoginId(signUpRequestDto.getLoginId()).orElse(null);
        if (user != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        authRepository.save(signUpRequestDto.toEntity(passwordEncoder));
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        log.info("signInRequestDto : {}", signInRequestDto);
        User user = authRepository.findByLoginId(signInRequestDto.getLoginId()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디를 가진 회원이 없습니다.")
        );
        log.info("user : {}", user);

        try {
           //Authentication authentication =
                   authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            signInRequestDto.getPassword()
                    )
           );
           return SignInResponseDto.builder()
                        .accessToken(createToken(user.getUuid()))
                        .build();
        } catch (Exception e) {
            throw new IllegalArgumentException("로그인 실패");
        }
    }
    @Override
    public TestTokenResponseDto testToken(TestTokenRequestDto testTokenRequestDto) {
        UUID uuid = jwtTokenProvider.useToken(testTokenRequestDto);
        TestTokenResponseDto testTokenResponseDto = TestTokenResponseDto.builder()
                .uuid(uuid).build();
        return testTokenResponseDto;
    }

    private String createToken(UUID uuid) {
        //return jwtTokenProvider.generateAccessToken(authentication, uuid);
        return jwtTokenProvider.generateAccessToken(uuid);
    }



}
