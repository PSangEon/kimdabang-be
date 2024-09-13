package com.kimdabang.kdbserver.season.mediaList.application;

import com.kimdabang.kdbserver.common.exception.CustomException;
import com.kimdabang.kdbserver.season.mediaList.dto.in.SeasonMediaListRequestDto;
import com.kimdabang.kdbserver.season.mediaList.dto.out.SeasonMediaListResponseDto;
import com.kimdabang.kdbserver.season.mediaList.infrastructure.SeasonMediaListRepository;
import com.kimdabang.kdbserver.season.season.domain.Season;
import com.kimdabang.kdbserver.season.season.infrastructure.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.kimdabang.kdbserver.common.exception.ErrorCode.SEASON_NOT_FOUND;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeasonMediaListServiceImpl implements SeasonMediaListService {

    private final SeasonMediaListRepository seasonMediaListRepository;
    private final SeasonRepository seasonRepository;

    @Override
    @Transactional
    public void addSeasonMediaList(SeasonMediaListRequestDto seasonMediaListRequestDto) {
        Season season = seasonRepository.findById(seasonMediaListRequestDto.getSeasonId())
                .orElseThrow(() -> new CustomException(SEASON_NOT_FOUND));

        seasonMediaListRepository.save(seasonMediaListRequestDto.toEntity(season));
    }

    @Override
    @Transactional
    public void updateSeasonMediaList(SeasonMediaListRequestDto seasonMediaListRequestDto) {

    }

    @Override
    @Transactional
    public void deleteSeasonMediaList(Long id) {

    }

    @Override
    public SeasonMediaListResponseDto getOneSeasonMediaList(Long id) {
        return null;
    }

    @Override
    public List<SeasonMediaListResponseDto> getAllSeasonMediaList() {
        return null;
    }
}
