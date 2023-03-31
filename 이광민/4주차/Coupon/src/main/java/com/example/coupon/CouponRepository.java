package com.example.coupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findAllByCodeType(String codeType);
//    @Query("select c from Coupon c where c.memberId = :memberId and c.id =: id and  c.overlap = :overlap")
//    boolean findByOverlapAndMemberId(@Param(value = "overlap") boolean overlap, @Param(value = "memberId") Long memberId, @Param(value = "id") Long couponId);
    boolean existsCouponByIdAndMemberId(Long couponId, Long memberId);

//    The given id must not be null!
//    ResponseEntity<Long> deleteByMemberIdAndId(Long couponId, Long memberId);

//  no converter found capable of converting from type [java.lang.integer] to type [org.springframework.http.responseentity<?>]
//  이건 왜 이렇게 나오고 void만 됨?
//  ResponseEntity<Long> deleteCouponByIdAndMemberId(Long couponId, Long memberId);
    void deleteCouponByIdAndMemberId(Long couponId, Long memberId);
    Coupon findByIdAndMemberId(Long couponId, Long memberId);
}