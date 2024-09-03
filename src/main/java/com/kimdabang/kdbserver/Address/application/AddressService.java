package com.kimdabang.kdbserver.Address.application;

import com.kimdabang.kdbserver.Address.dto.AddressAddRequestDto;
import com.kimdabang.kdbserver.Address.dto.AddressRequestDto;
import com.kimdabang.kdbserver.Address.dto.AddressResponseDto;

import java.util.List;

public interface AddressService {
    List<AddressResponseDto> getUserAddress(String Authorization);
    void addUserAddress(AddressAddRequestDto addressAddRequestDto);
    void putUserAddress(AddressRequestDto addressRequestDto);
    void deleteUserAddress(AddressRequestDto addressRequestDto);
}
