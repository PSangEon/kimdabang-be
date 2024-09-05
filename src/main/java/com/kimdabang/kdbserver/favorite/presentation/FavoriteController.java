package com.kimdabang.kdbserver.favorite.presentation;

import com.kimdabang.kdbserver.common.entity.CommonResponseEntity;
import com.kimdabang.kdbserver.favorite.application.FavoriteService;
import com.kimdabang.kdbserver.favorite.dto.in.FavoriteRequestDto;
import com.kimdabang.kdbserver.favorite.dto.out.FavoriteCheckResponseDto;
import com.kimdabang.kdbserver.favorite.vo.FavoriteCheckResponseVo;
import com.kimdabang.kdbserver.favorite.vo.FavoriteRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @GetMapping("/{productCode}")
    public CommonResponseEntity<FavoriteCheckResponseVo> getFavoriteCheck(
            @RequestHeader ("Authorization") String Authorization,
            @PathVariable String productCode) {
        FavoriteCheckResponseDto favoriteCheckResponseDto = favoriteService.getFavorite(productCode, Authorization);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "개별 좋아요 상태 조회 성공",
                favoriteCheckResponseDto.toVo()
        );
    }
}