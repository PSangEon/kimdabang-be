package com.kimdabang.kdbserver.Star.application;

import com.kimdabang.kdbserver.Star.domain.Star;
import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.Star.dto.StarAddRequestDto;
import com.kimdabang.kdbserver.Star.dto.StarResponseDto;
import com.kimdabang.kdbserver.Star.infrastructure.StarRepository;
import com.kimdabang.kdbserver.Star.infrastructure.StarRepositoryCustom;
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
public class StarServiceImpl implements StarService {

    private final JwtTokenProvider jwtTokenProvider;
    private final StarRepository starRepository;
    private final StarRepositoryCustom starRepositoryCustom;


    @Override
    public List<StarResponseDto> getStar(Date start, Date end, String Authorization) {
        String uuid = jwtTokenProvider.useToken(Authorization);
        List<Star> stars = starRepositoryCustom.getUserStarWithDate(uuid, start, end);
        log.info("userStars: {}", stars);
        if (stars != null) {
            //중복 개수 확인
            Map<String, Long> starCountMap = stars.stream()
                    .collect(Collectors.groupingBy(
                            userStar -> userStar.getDescription() + "_" + userStar.getCreatedAt().toString(),
                            Collectors.counting()
                    ));

            return stars.stream()
                    .map(userStar -> {
                        String groupKey = userStar.getDescription() + "_" + userStar.getCreatedAt().toString();
                        return StarResponseDto.builder()
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
    public void addStar(StarAddRequestDto starAddRequestDto){
        String uuid = jwtTokenProvider.useToken(starAddRequestDto.getAccesstoken());
        Date now = new Date();
        for(int i = 0; i< starAddRequestDto.getStarAmount(); i++) {
            starRepository.save(starAddRequestDto.toEntity(uuid, now));
        }
    }
}
