package com.blog.blogproject.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coupon")
@ToString
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", nullable = false)
    private CouponStatus couponStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", nullable = false)
    private CouponType couponType;

    @Builder

    public Coupon(Long id, String couponCode, String couponName, CouponStatus couponStatus, CouponType couponType) {
        this.id = id;
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
    }
}