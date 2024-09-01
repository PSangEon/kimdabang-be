package com.kimdabang.kdbserver.user.userStar.application;

import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.user.userStar.domain.UserStar;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarCreateRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarRequestDto;
import com.kimdabang.kdbserver.user.userStar.dto.UserStarResponseDto;
import com.kimdabang.kdbserver.user.userStar.infrastructure.UserStarRepository;
import com.kimdabang.kdbserver.user.userStar.infrastructure.UserStarRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserStarServiceImpl implements UserStarService{

    private final JwtTokenProvider jwtTokenProvider;
    private final UserStarRepository userStarRepository;
    private final UserStarRepositoryCustom userStarRepositoryCustom;


    @Override
    public List<UserStarResponseDto> getUserStar(UserStarRequestDto userStarRequestDto) {
        UUID uuid = jwtTokenProvider.useToken(userStarRequestDto.getAccessToken());
        List<UserStar> userStars = userStarRepositoryCustom.getUserStarWithDate(uuid, userStarRequestDto.getStartDate(), userStarRequestDto.getEndDate());
        log.info("userStars: {}",userStars);
        if (userStars != null) {
            //중복 개수 확인
            Map<String, Long> starCountMap = userStars.stream()
                    .collect(Collectors.groupingBy(
                            userStar -> userStar.getDescription() + "_" + userStar.getCreatedAt().toString(),
                            Collectors.counting()
                    ));

            return userStars.stream()
                    .map(userStar -> {
                        String groupKey = userStar.getDescription() + "_" + userStar.getCreatedAt().toString();
                        return UserStarResponseDto.builder()
                                .expirationDate(userStar.getExpirationDate())
                                .createdAt(userStar.getCreatedAt())
                                .isEcho(userStar.getIsEcho())
                                .description(userStar.getDescription())
                                .starAmount(starCountMap.get(groupKey).intValue())  // 중복 개수 설정
                                .build();
                    })
                    .distinct() //중복 제거
                    .toList();
        }
        //else {new IllegalArgumentException("적립된 별이 없습니다.");}
        return List.of();
    }
    @Override
    public void createUserStar(UserStarCreateRequestDto userStarCreateRequestDto){
        UUID uuid = jwtTokenProvider.useToken(userStarCreateRequestDto.getAccesstoken());
        Date now = new Date();
        for(int i =0;i<userStarCreateRequestDto.getStarAmount();i++) {
            userStarRepository.save(userStarCreateRequestDto.toEntity(uuid, now));
        }
    }
}
