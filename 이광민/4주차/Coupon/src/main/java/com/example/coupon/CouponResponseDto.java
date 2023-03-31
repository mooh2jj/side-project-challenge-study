package com.example.coupon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CouponResponseDto {
    private Long id;
    private Long memberId;
    private double discount;
    private LocalDateTime localDateTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String codeType;
    private boolean overlap;
    private boolean usageStatus;
    private boolean issuance;
    private Item item;
}
