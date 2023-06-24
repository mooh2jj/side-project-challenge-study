package com.study.sidejavachallenge.domain.coupon.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import com.study.sidejavachallenge.domain.coupon.dto.request.CouponCreateRequest;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@DynamicUpdate
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coupon")
@ToString
public class Coupon extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_code", nullable = false)
    @NotNull(message = "쿠폰 코드는 필수 입력 값입니다.")
    @Size(min = 1, max = 20, message = "쿠폰 코드는 1자 이상 20자 이하로 입력해주세요.")
    private String couponCode;

    @NotNull(message = "쿠폰 이름은 필수 입력 값입니다.")
    @Size(min = 1, max = 20, message = "쿠폰 이름은 1자 이상 20자 이하로 입력해주세요.")
    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", nullable = false)
    private CouponStatus couponStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", nullable = false)
    private CouponType couponType;

    @Column(name = "tags", nullable = false)
    private String tags;

    @Builder
    public Coupon(Long id, String couponCode, String couponName, CouponStatus couponStatus, CouponType couponType, String tags) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
        this.tags = tags;
    }

    public static Coupon mapToEntity(CouponCreateRequest createCouponRequest) {

        return Coupon.builder()
                .couponCode(createCouponRequest.getCouponCode())
                .couponName(createCouponRequest.getCouponName())
                .couponStatus(CouponStatus.UNUSED)
                .couponType(createCouponRequest.getCouponType())
                .tags(String.join("," , createCouponRequest.getTagList()))
                .build();
    }
}
