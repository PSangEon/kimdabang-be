package com.kimdabang.kdbserver.user.userAddress.dto;

import com.kimdabang.kdbserver.user.user.domain.User;
import com.kimdabang.kdbserver.user.userAddress.domain.UserAddress;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressRequestDto {
    private String accessToken;
    private Long id;
    private String address;
    private Boolean isDefault;
    private String addressName;

    public UserAddress toEntity(UserAddressRequestDto userAddressRequestDto, User user) {
        return UserAddress.builder()
                .id(userAddressRequestDto.getId())
                .address(userAddressRequestDto.getAddress())
                .isDefault(userAddressRequestDto.getIsDefault())
                .addressName(userAddressRequestDto.getAddressName())
                .user(user)
                .build();
    }
}
