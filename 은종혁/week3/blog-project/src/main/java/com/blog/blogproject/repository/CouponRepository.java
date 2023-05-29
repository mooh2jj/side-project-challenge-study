package com.blog.blogproject.repository;

import com.blog.blogproject.domain.Coupon;
import com.blog.blogproject.domain.CouponStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findAllByCouponStatus(CouponStatus couponStatus);
}
