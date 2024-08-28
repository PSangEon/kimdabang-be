package com.kimdabang.kdbserver.common.jwt;

import com.kimdabang.kdbserver.auth.dto.TestTokenRequestDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service
public class JwtTokenProvider {

    private final Environment env;

    //public String generateAccessToken(Authentication authentication, UUID uuid) {

    public String generateAccessToken(UUID uuid) {

        //Claims claims = Jwts.claims().subject(authentication.getName()).build();

        Date now = new Date();
        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());
        //log.info("claims = {}", claims);
        return Jwts.builder()
                .signWith(getSignKey())
                .claim("uuid", uuid)
                .issuedAt(expiration)
                .compact();
    }
    public Claims parseToken(String token) {
        try {
            // Jwts.parserBuilder()로 파서를 생성하고 서명 키를 설정합니다.
            return Jwts.parser()
                    .setSigningKey(getSignKey())  // 서명 키를 설정하여 토큰을 검증합니다.
                    .build()
                    .parseClaimsJws(token)        // 토큰을 파싱하고 검증하여 클레임을 추출합니다.
                    .getBody();                   // 추출된 클레임 반환
        } catch (JwtException | IllegalArgumentException e) {
            // 토큰이 유효하지 않거나 만료된 경우 예외 처리
            throw new RuntimeException("Invalid or expired JWT token", e);
        }
    }
    public UUID useToken(TestTokenRequestDto testTokenRequestDto) {
        Claims claims = parseToken(testTokenRequestDto.getAccessToken());          // 토큰에서 클레임을 추출합니다.
        String uuidString = claims.get("uuid", String.class);
        UUID uuid = UUID.fromString(uuidString);
        Date issuedAt = claims.getIssuedAt();

        return uuid;
    }

    public Key getSignKey() {
        return Keys.hmacShaKeyFor( env.getProperty("jwt.secret-key").getBytes() );
    }


}
