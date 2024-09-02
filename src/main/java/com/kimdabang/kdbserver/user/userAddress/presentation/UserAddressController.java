package com.kimdabang.kdbserver.user.userAddress.presentation;


import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.user.userAddress.application.UserAddressService;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressAddRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressRequestDto;
import com.kimdabang.kdbserver.user.userAddress.dto.UserAddressResponseDto;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressAddRequestVo;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressRequestVo;
import com.kimdabang.kdbserver.user.userAddress.vo.UserAddressResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/useraddress")
public class UserAddressController {
    private final UserAddressService userAddressService;

    @Operation(summary = "UserAddressAdd API", description = "UserAddressAdd API 입니다.", tags = {"useraddress-controller"})
    @PostMapping("/add-useraddress")
    public CommonResponseEntity<Void> addUserAddress(
            @RequestBody UserAddressAddRequestVo userAddressAddRequestVo) {
        userAddressService.addUserAddress(new ModelMapper().map(userAddressAddRequestVo, UserAddressAddRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }

    @Operation(summary = "UserAddressGet API", description = "UserAddressGet API 입니다.", tags = {"useraddress-controller"})
    @GetMapping("/get-useraddress")
    public CommonResponseEntity<List<UserAddressResponseVo>> getUserAddress(
            @RequestHeader ("Authorization") String Authorization) {
        List<UserAddressResponseDto> userAddressResponseDtoList =
                userAddressService.getUserAddress(Authorization);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "useraddress 조회 성공",
                userAddressResponseDtoList.stream()
                        .map(UserAddressResponseDto::toResponseVo)
                        .toList()
        );
    }
    @Operation(summary = "UserAddressPut API", description = "UserAddressPut API 입니다.", tags = {"useraddress-controller"})
    @PutMapping("/put-useraddress")
    public CommonResponseEntity<Void> putUserAddress(
            @RequestBody UserAddressRequestVo userAddressRequestVo) {
        userAddressService.putUserAddress(new ModelMapper().map(userAddressRequestVo, UserAddressRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
    @Operation(summary = "UserAddressDelete API", description = "UserAddressDelete API 입니다.", tags = {"useraddress-controller"})
    @DeleteMapping("/delete-useraddress")
    public CommonResponseEntity<Void> deleteUserAddress(
            @RequestBody UserAddressRequestVo userAddressRequestVo) {
        userAddressService.deleteUserAddress(new ModelMapper().map(userAddressRequestVo, UserAddressRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
}
