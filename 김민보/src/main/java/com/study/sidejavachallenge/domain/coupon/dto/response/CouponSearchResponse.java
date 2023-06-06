package com.study.sidejavachallenge.domain.coupon.dto.response;

import com.study.sidejavachallenge.domain.coupon.entity.CouponStatus;
import com.study.sidejavachallenge.domain.coupon.entity.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CouponSearchResponse {

    private String couponCode;
    private String couponName;
    private CouponStatus couponStatus;
    private CouponType couponType;

    @Builder
    public CouponSearchResponse(String couponCode, String couponName, CouponStatus couponStatus, CouponType couponType) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
    }
}
