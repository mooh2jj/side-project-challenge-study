package com.blog.blogproject.domain;

import lombok.Getter;

@Getter
public enum CouponStatus {

    USABLE("useable"),
    USED("used"),
    DISABLE("diable")
    ;

    private final String status;

    CouponStatus(String status) {
        this.status = status;
    }

    public String status() {
        return status;
    }

}
