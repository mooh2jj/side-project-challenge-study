package com.example.coupon.application;

import com.example.coupon.domain.Coupon;
import com.example.coupon.dto.request.RequestDto;
import com.example.coupon.exception.NotFoundIdException;
import com.example.coupon.repository.CouponRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {

  private final CouponRepository couponRepository;

  public Coupon createCoupon(RequestDto requestDto) {
    Coupon coupon = requestDto.toEntity();
    return couponRepository.save(coupon);
  }

  @Transactional(readOnly = true)
  public List<Coupon> getCoupons() {
    return couponRepository.findByUseCouponFalse();
  }

  @Transactional(readOnly = true)
  public Coupon getCoupon(Long id) {
    return couponRepository.findByIdFalse(id)
        .orElseThrow(()->new NotFoundIdException(id));
  }

  public Coupon updateCoupon(Long id, RequestDto requestDto) {
    Coupon coupon = couponRepository.findById(id)
        .orElseThrow(()->new NotFoundIdException(id));
    coupon.updateCoupon(requestDto);
    return coupon;
  }

  public void deleteCoupon(Long id) {
    Coupon coupon = couponRepository.findById(id)
        .orElseThrow(()->new NotFoundIdException(id));
    coupon.destroy();
  }

}
