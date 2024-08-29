package com.kimdabang.kdbserver.user.userStar.presentation;

import com.kimdabang.kdbserver.auth.dto.SignInRequestDto;
import com.kimdabang.kdbserver.auth.dto.SignUpRequestDto;
import com.kimdabang.kdbserver.auth.vo.SignInResponseVo;
import com.kimdabang.kdbserver.auth.vo.SignUpRequestVo;
import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.user.userStar.application.UserStarService;
import com.kimdabang.kdbserver.user.userStar.dto.TestUserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;
import com.kimdabang.kdbserver.user.userStar.vo.TestUserStarRequestVo;
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

    @Operation(summary = "UserStarAddTest API", description = "userStarAddTest API 입니다.", tags = {"Auth"})
    @PostMapping("/add-star")
    public CommonResponseEntity<Void> addUserStar(
            @RequestBody TestUserStarRequestVo testUserStarRequestVo) {
        userStarService.addUserStar(new ModelMapper().map(testUserStarRequestVo, TestUserStarRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
    @Operation(summary = "UserStarGet API", description = "userStarGet API 입니다.", tags = {"Auth"})
    @PostMapping("/get-star")
    public CommonResponseEntity<List<UserStarResponseVo>> getUserStar(
            @RequestBody UserStarRequestVo userStarRequestVo) {
        List<UserStarResponseDto> userStarResponseDtoList =
                userStarService.getUserStars(new ModelMapper().map(userStarRequestVo, UserStarRequestDto.class));
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "userStar 조회 성공",
                userStarResponseDtoList.stream()
                        .map(UserStarResponseDto::toResponseVo)
                        .toList()
        );
    }
}
