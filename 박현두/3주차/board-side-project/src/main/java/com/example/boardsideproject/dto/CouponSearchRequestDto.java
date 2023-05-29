package com.example.boardsideproject.dto;

import com.example.boardsideproject.entity.CouponStatus;
import com.example.boardsideproject.entity.CouponType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CouponSearchRequestDto {

    private CouponType couponType;

    private CouponStatus couponStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate expiredDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime issueDatetime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime endDate;
}
