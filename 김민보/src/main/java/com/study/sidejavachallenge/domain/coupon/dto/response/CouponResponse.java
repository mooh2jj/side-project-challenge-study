package com.study.sidejavachallenge.domain.coupon.dto.response;

import com.study.sidejavachallenge.domain.coupon.entity.Coupon;
import com.study.sidejavachallenge.domain.coupon.entity.CouponStatus;
import com.study.sidejavachallenge.domain.coupon.entity.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CouponResponse {

    private final Long id;
    private final String couponCode;
    private final String couponName;
    private final CouponStatus couponStatus;
    private final CouponType couponType;
    private final String tags;

    @Builder
    public CouponResponse(Long id, String couponCode, String couponName, CouponStatus couponStatus, CouponType couponType, String tags) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
        this.tags = tags;
    }

    static public CouponResponse mapToDto(Coupon coupon) {

        return CouponResponse.builder()
                .id(coupon.getId())
                .couponCode(coupon.getCouponCode())
                .couponName(coupon.getCouponName())
                .couponStatus(coupon.getCouponStatus())
                .couponType(coupon.getCouponType())
                .tags(coupon.getTags())
                .build();
    }
}
