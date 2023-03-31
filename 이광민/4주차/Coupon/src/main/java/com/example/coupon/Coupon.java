package com.example.coupon;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Coupon extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private double discount;
    private String codeType;
    //유효 기간 시작 시간
    @Column(nullable = false)
    private LocalDateTime startTime;
    //유효 기간 끝나는 시간
    @Column(nullable = false)
    private LocalDateTime endTime;
    //중복 가능 쿠폰인지
    private boolean overlap;
    //사용 했는지
    private boolean usageStatus;
    //발급 했는지
    private boolean issuance;
    //적용 항목
    private Item item;
    public void updateCoupon(boolean usageStatus){
        this.usageStatus = usageStatus;
    }
}
