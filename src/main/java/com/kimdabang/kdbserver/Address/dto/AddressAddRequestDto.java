package com.kimdabang.kdbserver.Address.dto;

import com.kimdabang.kdbserver.Address.domain.Address;
import com.kimdabang.kdbserver.user.domain.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressAddRequestDto {
    private String address;
    private Boolean isDefault;
    private String addressName;
    private String accessToken;

    public Address toEntity(AddressAddRequestDto addressAddRequestDto, User user) {
        return Address.builder()
                .address(addressAddRequestDto.getAddress())
                .isDefault(addressAddRequestDto.getIsDefault())
                .addressName(addressAddRequestDto.getAddressName())
                .user(user)
                .build();
    }
}
