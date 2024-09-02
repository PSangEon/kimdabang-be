package com.kimdabang.kdbserver.user.userAddress.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserAddressRequestVo {
    private String accessToken;
    private Long id;
    private String address;
    private Boolean isDefault;
    private String addressName;
}
