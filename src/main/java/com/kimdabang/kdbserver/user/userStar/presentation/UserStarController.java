package com.kimdabang.kdbserver.user.userStar.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.user.userStar.application.UserStarService;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarCreateRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;
import com.kimdabang.kdbserver.user.userStar.vo.UserStarCreateRequestVo;
import com.kimdabang.kdbserver.user.userStar.vo.UserStarRequestVo;
import com.kimdabang.kdbserver.user.userStar.vo.UserStarResponseVo;
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
@RequestMapping("/api/v1/userstar")
public class UserStarController {

    private final UserStarService userStarService;

    @Operation(summary = "UserStarAddTest API", description = "userStarAdd API 입니다.", tags = {"Auth"})
    @PostMapping("/add-userstar")
    public CommonResponseEntity<Void> addUserStar(
            @RequestBody UserStarCreateRequestVo userStarCreateRequestVo) {
        userStarService.createUserStar(new ModelMapper().map(userStarCreateRequestVo, UserStarCreateRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
    @Operation(summary = "UserStarGet API", description = "userStarGet API 입니다.", tags = {"Auth"})
    @PostMapping("/get-userstar")
    public CommonResponseEntity<List<UserStarResponseVo>> getUserStar(
            @RequestBody UserStarRequestVo userStarRequestVo) {
        List<UserStarResponseDto> userStarResponseDtoList =
                userStarService.getUserStar(new ModelMapper().map(userStarRequestVo, UserStarRequestDto.class));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "userStar 조회 성공",
                userStarResponseDtoList.stream()
                        .map(UserStarResponseDto::toResponseVo)
                        .toList()
        );
    }
}
