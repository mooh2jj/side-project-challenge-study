package com.blog.blogproject.application;

import com.blog.blogproject.domain.Coupon;
import com.blog.blogproject.domain.CouponStatus;
import com.blog.blogproject.dto.CouponRequest;
import com.blog.blogproject.dto.CouponResponse;
import com.blog.blogproject.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public List<CouponResponse> getAll() {
        List<Coupon> coupons = couponRepository.findAll();
        return coupons.stream()
                .map(CouponResponse::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CouponResponse> getByStatus(String status) {
        List<Coupon> coupons = couponRepository.findAllByCouponStatus();
        return coupons.stream()
                .map(CouponResponse::mapToDto)
                .collect(Collectors.toList());
    }
}
