package com.kimdabang.kdbserver.user.userStar.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.user.userStar.application.UserStarService;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarAddRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;
import com.kimdabang.kdbserver.user.userStar.vo.UserStarAddRequestVo;
import com.kimdabang.kdbserver.user.userStar.vo.UserStarResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/userstar")
public class UserStarController {

    private final UserStarService userStarService;

    @Operation(summary = "UserStarAdd API", description = "userStarAdd API 입니다.", tags = {"userstar-controller"})
    @PostMapping("/add-userstar")
    public CommonResponseEntity<Void> addUserStar(
            @RequestBody UserStarAddRequestVo userStarCreateRequestVo) {
        userStarService.addUserStar(new ModelMapper().map(userStarCreateRequestVo, UserStarAddRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
    @Operation(summary = "UserStarGet API", description = "userStarGet API 입니다.", tags = {"userstar-controller"})
    @GetMapping("/get-userstar")
    public CommonResponseEntity<List<UserStarResponseVo>> getUserStar(
            @RequestHeader ("Authorization") String Authorization,
            @RequestParam(value = "start") String start, @RequestParam(value = "end") String end) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        start = start+"-00:00:00";
        end = end+"-23:59:59";
        Date startDate = formatter.parse(start);
        Date endDate = formatter.parse(end);
        List<UserStarResponseDto> userStarResponseDtoList =
                userStarService.getUserStar(startDate, endDate, Authorization);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "userStar 조회 성공",
                userStarResponseDtoList.stream()
                        .map(UserStarResponseDto::toResponseVo)
                        .toList()
        );
    }
}
