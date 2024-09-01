package com.kimdabang.kdbserver.user.userAddress.dto;

import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressResponseVo;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressResponseDto {

    private String address;
    private Boolean isDefault;
    private String addressName;

    public UserAddressResponseVo toResponseVo() {
        return UserAddressResponseVo.builder()
                .address(address)
                .addressName(addressName)
                .isDefault(isDefault)
                .build();
    }
}
