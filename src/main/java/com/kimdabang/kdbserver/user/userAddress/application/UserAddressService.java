package com.kimdabang.kdbserver.user.userAddress.application;

import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressCreateRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressResponseDto;

import java.util.List;

public interface UserAddressService {
    List<UserAddressResponseDto> getUserAddress(UserAddressRequestDto userAddressRequestDto);
    void createUserAddress(UserAddressCreateRequestDto userAddressCreateRequestDto);
}
