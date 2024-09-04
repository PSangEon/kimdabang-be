package com.kimdabang.kdbserver.Star.application;

import com.kimdabang.kdbserver.Star.dto.StarAddRequestDto;
import com.kimdabang.kdbserver.Star.dto.StarResponseDto;

import java.util.Date;
import java.util.List;

public interface StarService {
    List<StarResponseDto> getStar(Date start, Date end, String Authorization);
    void addStar(StarAddRequestDto starAddRequestDto);
}
