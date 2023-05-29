package com.example.boardsideproject.domain.coupon.controller;

import com.example.boardsideproject.domain.coupon.dto.CouponInfoResponseDto;
import com.example.boardsideproject.domain.coupon.service.CouponService;
import com.example.boardsideproject.dto.CouponSearchRequestDto;
import com.example.boardsideproject.dto.DateDto;
import com.example.boardsideproject.entity.CouponType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;
    @GetMapping
    public ResponseEntity<List<CouponInfoResponseDto>> getCouponList(CouponSearchRequestDto dto) {
        return ResponseEntity.ok(couponService.getList(dto));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(DateDto dto) {
        return ResponseEntity.ok("test");
    }
}
