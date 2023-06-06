package com.study.sidejavachallenge.domain.coupon.service;

import com.study.sidejavachallenge.domain.coupon.dto.request.CouponCreateRequest;
import com.study.sidejavachallenge.domain.coupon.dto.request.CouponSearchRequest;
import com.study.sidejavachallenge.domain.coupon.dto.response.CouponResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface CouponService {

    CouponResponse createCoupon(CouponCreateRequest createCouponRequest);

    List<CouponResponse> getListCoupons(CouponSearchRequest couponSearchRequest);
}
