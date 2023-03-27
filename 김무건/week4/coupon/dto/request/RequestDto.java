package com.example.coupon.dto.request;

import com.example.coupon.domain.Coupon;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
  @NotBlank(message = "할인금 입력하세요.")
  private int amount;

  @NotBlank(message = "쿠폰 이름 입력하세요.")
  private String name;

  @NotBlank(message = "쿠폰 시작일 입력하세요")
  private LocalDateTime startDate;

  @NotBlank(message = "쿠폰 마감일을 입력하세요.")
  private LocalDateTime endDate;

  public Coupon toEntity(){
    return Coupon.builder()
        .name(name)
        .amount(amount)
        .startDate(startDate)
        .endDate(endDate)
        .build();
  }
}
