package com.kimdabang.kdbserver.user.userAddress.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressResponseVo {
    private Long id;
    private String address;
    private Boolean isDefault;
    private String addressName;
}
