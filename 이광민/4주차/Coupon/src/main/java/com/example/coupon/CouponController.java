package com.example.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;
    @GetMapping("/coupon/{codeType}")
    public List<Coupon> couponResponseDtoList(@PathVariable String codeType){
        return couponService.findCouponsByCodeType(codeType);
    }
    @GetMapping("/coupon")
    public List<Coupon> readAllCoupon(){
        return couponService.readAllCoupon();
    }
    @PostMapping("/coupon/{id}")
    public ResponseEntity<Long> createCoupon(@PathVariable Long id, @RequestBody CouponRequestDto requestDto){
        return couponService.createCoupon(id, requestDto);
    }
    @DeleteMapping("/couponDelete/{id}")
    public ResponseEntity<Long> deleteCoupon(@PathVariable Long id, @RequestParam Long memberId){
        return couponService.deleteCoupon(id, memberId);
    }
    @PatchMapping("/coupon/{id}")
    public ResponseEntity<String> useCoupon(@PathVariable Long id, @RequestBody CouponRequestDto requestDto){
        return couponService.useCoupon(id, requestDto);
    }
}
