package com.kimdabang.kdbserver.user.userAddress.dto;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressAddRequestDto {
    private String address;
    private Boolean isDefault;
    private String addressName;
    private String accessToken;

    public UserAddress toEntity(UserAddressAddRequestDto userAddressAddRequestDto, User user) {
        return UserAddress.builder()
                .address(userAddressAddRequestDto.getAddress())
                .isDefault(userAddressAddRequestDto.getIsDefault())
                .addressName(userAddressAddRequestDto.getAddressName())
                .user(user)
                .build();
    }
}
