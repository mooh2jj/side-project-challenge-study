package com.study.sidejavachallenge.domain.member.repository;

/*
import com.study.sidejavachallenge.domain.member.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.Optional;

public interface JwtRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.refreshToken = :refreshToken")
    void deleteByRefreshToken(@Param("refreshToken") String refreshToken);

    @Query("SELECT t FROM Token t WHERE t.accessToken = :accessToken AND t.refreshToken = :refreshToken AND t.expiredAt > :now")
    Optional<Token> findByAccessTokenAndRefreshTokenAndExpiredAtGreaterThan(@Param("accessToken") String accessToken, @Param("refreshToken") String refreshToken, @Param("now") LocalDateTime now);
}

 */
