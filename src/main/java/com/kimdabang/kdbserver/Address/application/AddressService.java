package com.kimdabang.kdbserver.Address.application;

import com.kimdabang.kdbserver.Address.dto.AddressAddRequestDto;
import com.kimdabang.kdbserver.Address.dto.AddressRequestDto;
import com.kimdabang.kdbserver.Address.dto.AddressResponseDto;

import java.util.List;

public interface AddressService {
    List<AddressResponseDto> getAddress(String Authorization);
    void addAddress(AddressAddRequestDto addressAddRequestDto);
    void putAddress(AddressRequestDto addressRequestDto);
    void deleteAddress(AddressRequestDto addressRequestDto);
}
