package com.kimdabang.kdbserver.Address.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseVo {
    private Long id;
    private String address;
    private Boolean isDefault;
    private String addressName;
}
