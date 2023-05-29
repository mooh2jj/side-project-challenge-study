package com.blog.blogproject.dto;

import com.blog.blogproject.domain.Coupon;
import lombok.Builder;
import lombok.Data;

@Data
public class CouponResponse {

    private String couponName;
    private String couponStatus;
    private String couponType;

    @Builder
    public CouponResponse(String couponName, String couponStatus, String couponType) {
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
    }

    public static CouponResponse mapToDto(Coupon coupon) {
        return CouponResponse.builder()
                .couponName(coupon.getCouponName())
                .couponStatus(coupon.getCouponStatus().status())
                .couponType(coupon.getCouponType().type())
                .build();
    }
}
