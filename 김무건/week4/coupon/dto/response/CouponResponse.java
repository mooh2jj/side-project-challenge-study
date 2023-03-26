package com.example.coupon.dto.response;

import com.example.coupon.domain.Coupon;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {
  private int amount;

  private String name;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

}
