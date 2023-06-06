package com.study.sidejavachallenge.domain.coupon.dto.request;

import com.study.sidejavachallenge.domain.coupon.entity.CouponStatus;
import com.study.sidejavachallenge.domain.coupon.entity.CouponType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CouponSearchRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Builder
    public CouponSearchRequest(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /*
    private String startDate;
    private String endDate;

    public LocalDateTime getStartDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(startDate + "T00:00:00", formatter);
    }

    public LocalDateTime getEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(endDate + "T23:59:59", formatter);
    }
    */
}
