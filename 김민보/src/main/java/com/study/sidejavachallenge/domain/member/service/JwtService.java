package com.study.sidejavachallenge.domain.member.service;

/*
import com.study.sidejavachallenge.domain.member.dto.request.JwtReissueRequestDto;
import com.study.sidejavachallenge.domain.member.entity.Token;
import com.study.sidejavachallenge.domain.member.repository.JwtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtRepository jwtRepository;

    @Transactional
    public void createJwt(String accessToken, String refreshToken, User user) {
        log.info("JwtService insertJwt run...");
        Token token = Token.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .user(user)
                .build();
        jwtRepository.save(token);
    }

    @Transactional
    public void deleteByRefreshToken(String refreshToken) {
        log.info("JwtService deleteByRefreshToken run...");
        jwtRepository.deleteByRefreshToken(refreshToken);
    }

    @Transactional(readOnly = true)
    public Optional<Token> findByDto(JwtReissueRequestDto requestDto) {

        String accessToken = requestDto.getAccessToken();
        String refreshToken = requestDto.getRefreshToken();
        LocalDateTime now = LocalDateTime.now();

        return jwtRepository.findByAccessTokenAndRefreshTokenAndExpiredAtGreaterThan(accessToken, refreshToken, now);
    }
}

 */
