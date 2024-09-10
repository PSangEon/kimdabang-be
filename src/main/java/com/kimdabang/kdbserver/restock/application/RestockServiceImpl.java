package com.kimdabang.kdbserver.restock.application;

import com.kimdabang.kdbserver.common.jwt.JwtTokenProvider;
import com.kimdabang.kdbserver.restock.domain.Restock;
import com.kimdabang.kdbserver.restock.dto.in.RestockRequestDto;
import com.kimdabang.kdbserver.restock.dto.out.RestockResponseDto;
import com.kimdabang.kdbserver.restock.infrastructure.RestockRepository;
import com.kimdabang.kdbserver.restock.infrastructure.RestockRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RestockServiceImpl implements RestockService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RestockRepository restockRepository;
    private final RestockRepositoryCustom restockRepositoryCustom;

    @Override
    public List<RestockResponseDto> getRestock(String Authorization) {
        List<Restock> restocks = restockRepository.findByUuid(jwtTokenProvider.useToken(Authorization));
        log.info("restocks: {}", restocks);
        if (restocks != null) {
            return restocks.stream()
                    .map(restock -> RestockResponseDto.builder()
                            .restockDate(restock.getRestockDate())
                            .status(restock.getStatus())
                            .productCode(restock.getProductCode())
                            .calledDate(restock.getCalledDate())
                            .build())
                    .toList();
        }
        return List.of();
    }
    @Override
    public void addRestock(RestockRequestDto restockRequestDto) {
        Restock Restock = restockRepositoryCustom.getRestockWithProductCode(jwtTokenProvider.useToken(restockRequestDto.getAccessToken()), restockRequestDto.getProductCode())
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다"));
        if(Restock == null) { //중복방지 예외처리
            restockRepository.save(restockRequestDto.toEntity(jwtTokenProvider.useToken(restockRequestDto.getAccessToken())));
        }
    }
    @Override
    public void deleteRestock(RestockRequestDto restockRequestDto) {
        Restock deleteRestock = restockRepositoryCustom.getRestockWithProductCode(jwtTokenProvider.useToken(restockRequestDto.getAccessToken()), restockRequestDto.getProductCode())
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다"));
        restockRepository.delete(deleteRestock);
    }

}
