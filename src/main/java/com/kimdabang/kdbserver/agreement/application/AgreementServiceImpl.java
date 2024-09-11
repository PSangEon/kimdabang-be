package com.kimdabang.kdbserver.agreement.application;

import com.kimdabang.kdbserver.agreement.domain.Agreement;
import com.kimdabang.kdbserver.agreement.dto.AgreementRequestDto;
import com.kimdabang.kdbserver.agreement.dto.AgreementResponseDto;
import com.kimdabang.kdbserver.agreement.infrastructure.AgreementRepository;
import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.domain.User;
import com.kimdabang.kdbserver.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final JwtTokenProvider jwtTokenProvider;
    private final AgreementRepository agreementRepository;
    private final UserRepository userRepository;

    @Override
    public AgreementResponseDto getAgreement(String accessToken) {
        User user = userRepository.findByUuid(jwtTokenProvider.useToken(accessToken)).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        Agreement agreement = agreementRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        return AgreementResponseDto.toResponseDto(agreement);
    }
    @Override
    public void putAgreement(AgreementRequestDto agreementRequestDto, String accessToken) {
        User user = userRepository.findByUuid(jwtTokenProvider.useToken(accessToken)).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        Agreement agreement = agreementRepository.findByUser(user).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );

        agreementRepository.save(agreementRequestDto.toEntity(agreement));
    }

}