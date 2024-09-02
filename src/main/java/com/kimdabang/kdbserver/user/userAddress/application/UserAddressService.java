package com.kimdabang.kdbserver.user.userAddress.application;

import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressAddRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressResponseDto;

import java.util.List;

public interface UserAddressService {
    List<UserAddressResponseDto> getUserAddress(String Authorization);
    void addUserAddress(UserAddressAddRequestDto userAddressAddRequestDto);
    void putUserAddress(UserAddressRequestDto userAddressRequestDto);
    void deleteUserAddress(UserAddressRequestDto userAddressRequestDto);
}
