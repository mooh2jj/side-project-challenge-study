package com.study.sidejavachallenge.domain.coupon.dto.request;

import com.study.sidejavachallenge.domain.coupon.entity.CouponStatus;
import com.study.sidejavachallenge.domain.coupon.entity.CouponType;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CouponCreateRequest {

    private String couponCode;
    private String couponName;
    private CouponStatus couponStatus;
    private CouponType couponType;
    private List<String> tagList;       // ["태그1", "태그2", "태그3"] => tags : "태그,태그2,태그3"

    @Builder
    public CouponCreateRequest(String couponCode,
                               String couponName,
                               CouponStatus couponStatus,
                               CouponType couponType,
                               List<String> tagList) {

        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
        this.tagList = tagList;
    }
}
