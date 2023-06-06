package com.study.sidejavachallenge.domain.coupon.controller;

import com.study.sidejavachallenge.domain.coupon.dto.request.CouponCreateRequest;
import com.study.sidejavachallenge.domain.coupon.dto.request.CouponSearchRequest;
import com.study.sidejavachallenge.domain.coupon.dto.response.CouponResponse;
import com.study.sidejavachallenge.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/api/coupon")
    public ResponseEntity<CouponResponse> create (@Valid @RequestBody CouponCreateRequest couponCreateRequest) {
        log.info("CouponController클래스의 create() 메서드실행");

        CouponResponse coupon = couponService.createCoupon(couponCreateRequest);

        return new ResponseEntity<>(coupon, HttpStatus.CREATED);
    }

    @GetMapping("/api/coupon/{createdAt}")
    public List<CouponResponse> getList(@PathVariable CouponSearchRequest createdAt) {

        log.info("CouponController클래스의 getList() 메서드실행");

        List<CouponResponse> listCoupons = couponService.getListCoupons(createdAt);

        return listCoupons;
    }

}
