package com.kimdabang.kdbserver.user.userAddress.application;

import com.kimdabang.kdbserver.auth.infrastructure.AuthRepository;
import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressAddRequestDto;
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
    public List<UserAddressResponseDto> getUserAddress(String Authorization){
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(Authorization)).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        List<UserAddress> userAddresses = userAddressRepositoryCustom.getUserAddressWithUser(user);
        log.info("userAddresses: {}",userAddresses);
        if (userAddresses != null) {
            return userAddresses.stream()
                    .map(userAddress -> UserAddressResponseDto.builder()
                            .id(userAddress.getId())
                            .address(userAddress.getAddress())
                            .isDefault(userAddress.getIsDefault())
                            .addressName(userAddress.getAddressName())
                            .build())
                    .toList();
        }
        return List.of();
    }
    @Override
    public void addUserAddress(UserAddressAddRequestDto userAddressAddRequestDto) {
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(userAddressAddRequestDto.getAccessToken())).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        userAddressRepository.save(userAddressAddRequestDto.toEntity(userAddressAddRequestDto, user));
    }
    @Override
    public void putUserAddress(UserAddressRequestDto userAddressRequestDto) {
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(userAddressRequestDto.getAccessToken())).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );

        userAddressRepository.save(userAddressRequestDto.toEntity(userAddressRequestDto, user));
    }

    @Override
    public void deleteUserAddress(UserAddressRequestDto userAddressRequestDto) {
        User user = authRepository.findByUuid(jwtTokenProvider.useToken(userAddressRequestDto.getAccessToken())).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
        );
        UserAddress deleteUserAddress = userAddressRepositoryCustom.findByUserAddressIdWithUser(userAddressRequestDto.getId(), user)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        userAddressRepository.delete(deleteUserAddress);
    }

}
