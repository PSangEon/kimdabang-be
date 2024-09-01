package com.kimdabang.kdbserver.user.userAddress.presentation;


import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.user.userAddress.application.UserAddressService;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressCreateRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressResponseDto;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressCreateRequestVo;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressRequestVo;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/useraddress")
public class UserAddressController {
    private final UserAddressService userAddressService;

    @Operation(summary = "UserAddressAdd API", description = "UserAddressAdd API 입니다.", tags = {"Auth"})
    @PostMapping("/add-useraddress")
    public CommonResponseEntity<Void> addUserAddress(
            @RequestBody UserAddressCreateRequestVo userAddressCreateRequestVo) {
        userAddressService.createUserAddress(new ModelMapper().map(userAddressCreateRequestVo, UserAddressCreateRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @Operation(summary = "UserAddressGet API", description = "UserAddressGet API 입니다.", tags = {"Auth"})
    @PostMapping("/get-useraddress")
    public CommonResponseEntity<List<UserAddressResponseVo>> getUserAddress(
            @RequestBody UserAddressRequestVo userAddressRequestVo) {
        List<UserAddressResponseDto> userAddressResponseDtoList =
                userAddressService.getUserAddress(new ModelMapper().map(userAddressRequestVo, UserAddressRequestDto.class));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "useraddress 조회 성공",
                userAddressResponseDtoList.stream()
                        .map(UserAddressResponseDto::toResponseVo)
                        .toList()
        );
    }
}
