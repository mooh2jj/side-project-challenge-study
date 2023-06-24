package com.study.sidejavachallenge.domain.coupon.service;

import com.study.sidejavachallenge.domain.coupon.dto.request.CouponCreateRequest;
import com.study.sidejavachallenge.domain.coupon.dto.request.CouponSearchRequest;
import com.study.sidejavachallenge.domain.coupon.dto.response.CouponResponse;
import com.study.sidejavachallenge.domain.coupon.entity.Coupon;
import com.study.sidejavachallenge.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    @Override
    public CouponResponse createCoupon(CouponCreateRequest createCouponRequest) {
        log.info("CouponServiceImpl클래스의 createCoupon() 메서드 실행");
        
        Coupon coupon = Coupon.mapToEntity(createCouponRequest);
        Coupon save = couponRepository.save(coupon);

        return CouponResponse.mapToDto(save);
    }

    @Override
    public List<CouponResponse> getListCoupons(CouponSearchRequest couponSearchRequest) {
        log.info("CouponServiceImpl클래스의 getListCoupons() 메서드 실행");

        List<Coupon> coupons = couponRepository.getAllByCreatedAt(couponSearchRequest.getCreatedAt());

        return coupons.stream().map(CouponResponse::mapToDto).collect(Collectors.toList());
    }

}
