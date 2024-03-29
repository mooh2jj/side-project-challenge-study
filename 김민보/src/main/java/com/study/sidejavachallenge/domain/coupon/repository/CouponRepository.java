package com.study.sidejavachallenge.domain.coupon.repository;

import com.study.sidejavachallenge.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("select c from Coupon c where c.createdAt = :createdAt")
    List<Coupon> getAllByCreatedAt(@Param("createdAt") LocalDateTime createdAt);
}
