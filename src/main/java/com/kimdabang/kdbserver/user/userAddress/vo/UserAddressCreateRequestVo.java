package com.kimdabang.kdbserver.user.userAddress.vo;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserAddressCreateRequestVo {
    private String address;
    private Boolean isDefault;
    private String addressName;
    private String accessToken;
}
