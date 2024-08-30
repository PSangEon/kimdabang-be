package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.userStar.domain.UserStar;
import com.kimdabang.kdbserver.user.userStar.dto.TestUserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;
import com.kimdabang.kdbserver.user.userStar.infrastructure.UserStarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserStarServiceImpl implements UserStarService{

    private final JwtTokenProvider jwtTokenProvider;
    private final UserStarRepository userStarRepository;


//    @Override
//    public UserStarResponseDto getUserStar(UserStarRequestDto userStarRequestDto) {
//        UUID uuid = jwtTokenProvider.useToken(userStarRequestDto.getAccessToken());
//        UserStar getUserstar = userStarRepository.findByUuid(uuid).orElseThrow(
//                () -> new IllegalArgumentException("적립된 별이 없습니다."));
//        UserStarResponseDto userStarResponseDto = UserStarResponseDto.builder()
//                .expirationDate(getUserstar.getExpirationDate())
//                .createdAt(getUserstar.getCreatedAt())
//                .isEcho(getUserstar.getIsEcho())
//                .build();
//        log.info("userStarResponseDto: {}", userStarResponseDto);
//        return userStarResponseDto;
//    }
    @Override
    public List<UserStarResponseDto> getUserStar(UserStarRequestDto userStarRequestDto) {
        UUID uuid = jwtTokenProvider.useToken(userStarRequestDto.getAccessToken());
        List<UserStar> userStars = userStarRepository.findByUuid(uuid);
        if (userStars != null) {
            return userStars.stream()
                    .map(userStar -> UserStarResponseDto.builder()
                            .expirationDate(userStar.getExpirationDate())
                            .createdAt(userStar.getCreatedAt())
                            .isEcho(userStar.getIsEcho())
                            .starAmount(1)
                            .build())
                    .toList();
        }
        //else {new IllegalArgumentException("적립된 별이 없습니다.");}
        return List.of();
    }
    @Override
    public void addUserStar(TestUserStarRequestDto testUserStarRequestDto){
        UUID uuid = jwtTokenProvider.useToken(testUserStarRequestDto.getAccesstoken());
        userStarRepository.save(testUserStarRequestDto.toEntity(uuid));
    }
}
