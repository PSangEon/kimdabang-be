package com.kimdabang.kdbserver.season.season.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.season.season.application.SeasonService;
import com.kimdabang.kdbserver.season.season.dto.in.SeasonRequestDto;
import com.kimdabang.kdbserver.season.season.vo.SeasonRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/season")
public class SeasonController {

    private final SeasonService seasonService;

    @PostMapping
    public CommonResponseEntity<Void> createSeason(@RequestBody SeasonRequestVo seasonRequestVo) {
        log.info("seasonRequestVo = {}", seasonRequestVo);
        SeasonRequestDto seasonRequestDto = SeasonRequestDto.builder()
                .id(seasonRequestVo.getId())
                .name(seasonRequestVo.getName())
                .description(seasonRequestVo.getDescription())
                .startDate(seasonRequestVo.getStartDate())
                .endDate(seasonRequestVo.getEndDate())
                .discount(seasonRequestVo.getDiscount())
                .build();
        seasonService.addSeason(seasonRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "시즌 등록 성공",
                null
        );
    }

    @PutMapping
    public CommonResponseEntity<Void> updateSeason(@RequestBody SeasonRequestVo seasonRequestVo) {
        log.info("seasonRequestVo = {}", seasonRequestVo);
        SeasonRequestDto seasonRequestDto = SeasonRequestDto.builder()
                .name(seasonRequestVo.getName())
                .description(seasonRequestVo.getDescription())
                .startDate(seasonRequestVo.getStartDate())
                .endDate(seasonRequestVo.getEndDate())
                .discount(seasonRequestVo.getDiscount())
                .build();
        seasonService.updateSeason(seasonRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "시즌 업데이트 성공",
                null
        );
    }

    @DeleteMapping
    public CommonResponseEntity<Void> deleteSeason(@RequestParam Long id) {
        log.info("seasonId = {}", id);
        seasonService.deleteSeason(id);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "시즌 삭제 성공",
                null
        );
    }
}