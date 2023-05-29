package com.example.boardsideproject.domain.coupon.dto;

import com.example.boardsideproject.entity.CouponStatus;
import com.example.boardsideproject.entity.CouponType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CouponInfoResponseDto {

    private long couponId;

    private String couponCode;

    private String couponName;

    private CouponType couponType;

    private CouponStatus couponStatus;

    private LocalDate expiredDate;

    private LocalDateTime issueDatetime;
    @Builder
    public CouponInfoResponseDto(long couponId, String couponCode, String couponName, CouponType couponType, CouponStatus couponStatus, LocalDate expiredDate, LocalDateTime issueDatetime) {
        this.couponId = couponId;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponType = couponType;
        this.couponStatus = couponStatus;
        this.expiredDate = expiredDate;
        this.issueDatetime = issueDatetime;
    }
}
