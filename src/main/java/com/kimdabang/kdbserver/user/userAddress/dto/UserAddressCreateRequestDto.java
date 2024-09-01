package com.kimdabang.kdbserver.user.userAddress.dto;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressCreateRequestDto {
    private String address;
    private Boolean isDefault;
    private String addressName;
    private String accessToken;

    public UserAddress toEntity(UserAddressCreateRequestDto userAddressCreateRequestDto, User user) {
        return UserAddress.builder()
                .address(userAddressCreateRequestDto.getAddress())
                .isDefault(userAddressCreateRequestDto.getIsDefault())
                .addressName(userAddressCreateRequestDto.getAddressName())
                .user(user)
                .build();
    }
}
