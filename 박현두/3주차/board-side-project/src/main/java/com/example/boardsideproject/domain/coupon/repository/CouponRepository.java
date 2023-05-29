package com.example.boardsideproject.domain.coupon.repository;

import com.example.boardsideproject.dto.CouponSearchRequestDto;
import com.example.boardsideproject.entity.Coupon;
import com.example.boardsideproject.entity.CouponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("select c from Coupon c where c.couponType = ?1")
    List<Coupon> findByCouponType(CouponType couponType);


    @Query("select c from Coupon c where c.expiredDate = ?1")
    List<Coupon> findByExpiredDate(LocalDate expiredDate);

    @Query("select c from Coupon c where c.issueDatetime = ?1")
    List<Coupon> findByIssueDatetime(LocalDateTime issueDatetime);

    @Query("select c from Coupon c where c.issueDatetime between ?1 and ?2")
    List<Coupon> findBetweenIssueDatetime(LocalDateTime startDatetime, LocalDateTime endDatetime);
}
