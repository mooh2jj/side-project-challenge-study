package com.blog.blogproject.domain;

public enum CouponType {

    PERCENTAGE_DISCOUNT("percentage_discount"),
    ABSOLUTE_DISCOUNT("absolute_discount")
    ;

    private final String type;

    CouponType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

}
