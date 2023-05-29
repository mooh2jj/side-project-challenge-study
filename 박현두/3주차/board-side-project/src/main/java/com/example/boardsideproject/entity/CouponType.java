package com.example.boardsideproject.entity;

public enum CouponType {
    DISCOUNT("할인 쿠폰"),
    POINT("포인트 쿠폰")
    ;
    private String description;

    CouponType(String description) {
        this.description = description;
    }
}
