package com.kimdabang.kdbserver.user.userAddress.application;

import com.kimdabang.kdbserver.auth.infrastructure.AuthRepository;
import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressCreateRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressResponseDto;
import com.kimdabang.kdbserver.user.userAddress.infrastructure.UserAddressRepository;
import com.kimdabang.kdbserver.user.userAddress.infrastructure.UserAddressRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserAddressServiceImpl implements UserAddressService{

    private final AuthRepository authRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserAddressRepository userAddressRepository;
    private final UserAddressRepositoryCustom userAddressRepositoryCustom;

    @Override
    public List<UserAddressResponseDto> getUserAddress(UserAddressRequestDto userAddressRequestDto){
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(userAddressRequestDto.getAccessToken())).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        List<UserAddress> userAddresses = userAddressRepositoryCustom.getUserAddressWithUser(user);
        log.info("userAddresses: {}",userAddresses);
        if (userAddresses != null) {
            return userAddresses.stream()
                    .map(userAddress -> UserAddressResponseDto.builder()
                            .address(userAddress.getAddress())
                            .isDefault(userAddress.getIsDefault())
                            .addressName(userAddress.getAddressName())
                            .build())
                    .toList();
        }
        return List.of();
    }
    @Override
    public void createUserAddress(UserAddressCreateRequestDto userAddressCreateRequestDto) {
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(userAddressCreateRequestDto.getAccessToken())).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        userAddressRepository.save(userAddressCreateRequestDto.toEntity(userAddressCreateRequestDto, user));
    }
}
