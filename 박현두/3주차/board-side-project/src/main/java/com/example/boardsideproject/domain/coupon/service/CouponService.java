package com.example.boardsideproject.domain.coupon.service;

import com.example.boardsideproject.domain.coupon.dto.CouponInfoResponseDto;
import com.example.boardsideproject.dto.CouponSearchRequestDto;
import com.example.boardsideproject.entity.CouponType;

import java.util.List;

public interface CouponService {
    public List<CouponInfoResponseDto> getList(CouponSearchRequestDto dto);
}
