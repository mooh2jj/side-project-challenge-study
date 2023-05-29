package com.blog.blogproject.api;

import com.blog.blogproject.application.CouponService;
import com.blog.blogproject.dto.CouponResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/coupon")
    public ResponseEntity<List<CouponResponse>> getAll() {
        return new ResponseEntity<>(couponService.getAll(), HttpStatus.OK);
    }
}
