package com.kimdabang.kdbserver.favorite.application;

import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.favorite.domain.Favorite;
import com.kimdabang.kdbserver.favorite.dto.in.FavoriteRequestDto;
import com.kimdabang.kdbserver.favorite.dto.out.FavoriteCheckResponseDto;
import com.kimdabang.kdbserver.favorite.infrastructure.FavoriteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public FavoriteCheckResponseDto getFavorite(String productCode, String Authorization) {

        String userUuid = jwtTokenProvider.useToken(Authorization);

        Favorite favorite = favoriteRepository.findByProductCodeAndUserUuid(productCode, userUuid)
                .orElseThrow(() -> new EntityNotFoundException("Favorite not found"));

        boolean favoriteStatus;

        if (favorite == null) {
            favoriteStatus = false;
        } else {
            favoriteStatus = !favorite.isCanceled();
        }

        return new FavoriteCheckResponseDto(favoriteStatus);
    }

    @Override
    public void addFavorite(FavoriteRequestDto favoriteDto) {

        String userUuid = jwtTokenProvider.useToken(favoriteDto.getAccessToken());

        Favorite favorite = favoriteRepository.findByProductCodeAndUserUuid(favoriteDto.getProductCode(), userUuid)
                .orElseThrow(() -> {
                    if (!favoriteRepository.existsByProductCode(favoriteDto.getProductCode())) {
                        throw new EntityNotFoundException("Favorite not found with productCode: " + favoriteDto.getProductCode());
                    }

                    if (!favoriteRepository.existsByUserUuid(userUuid)) {
                        throw new EntityNotFoundException("Favorite not found with userUuid: " + userUuid);
                    }

                    return new EntityNotFoundException("Favorite not found with productCode and UserUuid: " + favoriteDto.getProductCode() + ", " + userUuid);
                });

        favoriteRepository.save(favoriteDto.toFavoriteEntity(userUuid));

    }

    @Override
    public void putFavorite(FavoriteRequestDto favoriteDto) {

        String userUuid = jwtTokenProvider.useToken(favoriteDto.getAccessToken());

        Favorite favorite = favoriteRepository.findByProductCodeAndUserUuid(favoriteDto.getProductCode(), userUuid)
                .orElseThrow(() -> new EntityNotFoundException("Favorite not found with productCode and UserUuid: " + favoriteDto.getProductCode() + ", " + userUuid));

        favorite.change();

        favoriteRepository.save(favoriteDto.toFavoriteEntity(userUuid));

    }
}