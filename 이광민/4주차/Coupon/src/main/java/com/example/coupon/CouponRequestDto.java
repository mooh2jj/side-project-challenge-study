package com.example.coupon;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequestDto {
    private Long id;
    private Long memberId;
    private LocalDateTime startTime;
    //유효 기간 끝나는 시간
    private LocalDateTime endTime;
    private double discount;
    private String codeType;
    private boolean overlap;
    private boolean usageStatus;
    private boolean issuance;
    private Item item;
}
