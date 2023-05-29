package com.example.boardsideproject.entity;

public enum CouponStatus {
    USED("사용됨")
    , UNUSED("사용안됨")
    ;
    private String description;

    CouponStatus(String description) {
        this.description = description;
    }
}
