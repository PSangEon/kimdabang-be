package com.kimdabang.kdbserver.Star.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.common.entity.CommonResponseMessage;
import com.kimdabang.kdbserver.Star.application.StarService;
import com.kimdabang.kdbserver.Star.dto.StarAddRequestDto;
import com.kimdabang.kdbserver.Star.dto.StarResponseDto;
import com.kimdabang.kdbserver.Star.vo.StarAddRequestVo;
import com.kimdabang.kdbserver.Star.vo.StarResponseVo;
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
public class StarController {

    private final StarService starService;

    @Operation(summary = "UserStarAdd API", description = "userStarAdd API 입니다.", tags = {"userstar-controller"})
    @PostMapping("/add-userstar")
    public CommonResponseEntity<Void> addStar(
            @RequestBody StarAddRequestVo starAddRequestVo) {
        starService.addStar(new ModelMapper().map(starAddRequestVo, StarAddRequestDto.class));
        return new CommonResponseEntity<>(HttpStatus.OK, CommonResponseMessage.SUCCESS.getMessage(), null);
    }
    @Operation(summary = "UserStarGet API", description = "userStarGet API 입니다.", tags = {"userstar-controller"})
    @GetMapping("/get-userstar")
    public CommonResponseEntity<List<StarResponseVo>> getStar(
            @RequestHeader ("Authorization") String Authorization,
            @RequestParam(value = "start") String start, @RequestParam(value = "end") String end) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        start = start+"-00:00:00";
        end = end+"-23:59:59";
        Date startDate = formatter.parse(start);
        Date endDate = formatter.parse(end);
        List<StarResponseDto> starResponseDtoList =
                starService.getStar(startDate, endDate, Authorization);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "Star 조회 성공",
                starResponseDtoList.stream()
                        .map(StarResponseDto::toResponseVo)
                        .toList()
        );
    }
}
