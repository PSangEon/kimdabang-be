package com.kimdabang.kdbserver.Star.application;

import com.kimdabang.kdbserver.Star.dto.in.StarAddRequestDto;
import com.kimdabang.kdbserver.Star.dto.out.StarAmountResponseDto;
import com.kimdabang.kdbserver.Star.dto.out.StarResponseDto;

import java.util.Date;
import java.util.List;

public interface StarService {
    List<StarResponseDto> getStar(Date start, Date end, String Authorization);
    void addStar(StarAddRequestDto starAddRequestDto);
    StarAmountResponseDto getStarAmount(String Authorization);
}
