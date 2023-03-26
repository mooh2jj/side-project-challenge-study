package com.example.coupon.controller;

import com.example.coupon.domain.Coupon;
import com.example.coupon.dto.request.RequestDto;
import com.example.coupon.dto.response.CouponResponse;
import com.example.coupon.application.CouponService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

  private final CouponService couponService;

  /**
   * 새로운 쿠폰을 생성합니다.
   *
   * @param requestDto
   * @return
   */
  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public CouponResponse createCoupon(
      @Valid @RequestBody RequestDto requestDto
  ) {
    Coupon coupon = couponService.createCoupon(requestDto);
    return convertCouponData(coupon);
  }

  /**
   * 모든 쿠폰을 조회
   *
   * @return
   */
  @GetMapping("/getCoupons")
  @ResponseStatus(HttpStatus.OK)
  public List<CouponResponse> getCoupons() {
    return couponService.getCoupons().stream()
        .map(this::convertCouponData)
        .collect(Collectors.toList());
  }

  /**
   * 특정 id를 가진 쿠폰을 조회
   *
   * @param id
   * @return
   */
  @GetMapping("/getCoupon/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CouponResponse getCoupon(
      @PathVariable Long id
  ) {
    Coupon coupon = couponService.getCoupon(id);
    return convertCouponData(coupon);
  }

  /**
   * 특정 id를 가진 쿠폰을 수정
   *
   * @param id
   * @param requestDto
   * @return
   */
  @PatchMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public CouponResponse updateCoupon(
      @PathVariable Long id,
      @RequestBody RequestDto requestDto
  ) {
    Coupon coupon = couponService.updateCoupon(id, requestDto);
    return convertCouponData(coupon);
  }


  /**
   * 특정 쿠폰을 삭제
   *
   * @param id
   */
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    couponService.deleteCoupon(id);
  }

  private CouponResponse convertCouponData(Coupon coupon) {
    return CouponResponse.builder()
        .name(coupon.getName())
        .amount(coupon.getAmount())
        .startDate(coupon.getStartDate())
        .endDate(coupon.getEndDate())
        .build();
  }

}

