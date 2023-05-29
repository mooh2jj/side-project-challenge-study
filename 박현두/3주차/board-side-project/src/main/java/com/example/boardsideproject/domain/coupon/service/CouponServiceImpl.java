package com.example.boardsideproject.domain.coupon.service;

import com.example.boardsideproject.domain.coupon.dto.CouponInfoResponseDto;
import com.example.boardsideproject.domain.coupon.repository.CouponRepository;
import com.example.boardsideproject.dto.CouponSearchRequestDto;
import com.example.boardsideproject.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{
    private final CouponRepository couponRepository;
    @Override
    public List<CouponInfoResponseDto> getList(CouponSearchRequestDto dto) {
        List<Coupon> couponList = couponRepository.findBetweenIssueDatetime(dto.getStartDate(), dto.getEndDate());
        return couponList.stream().map(coupon -> CouponInfoResponseDto.builder()
                .couponId(coupon.getId())
                .couponCode(coupon.getCouponCode())
                .couponName(coupon.getCouponName())
                .couponStatus(coupon.getCouponStatus())
                .couponType(coupon.getCouponType())
                .expiredDate(coupon.getExpiredDate())
                .issueDatetime(coupon.getIssueDatetime())
                .build()).collect(Collectors.toList());
    }
}
