package com.example.coupon;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    @Transactional(readOnly = true)
    public List<Coupon> couponResponseDtoList(String codeType){
        return couponRepository.findAllByCodeType(codeType);
    }
    @Transactional
    public ResponseEntity<Long> createCoupon(Long id, CouponRequestDto requestDto) {
        boolean existsCoupon = couponRepository.existsCouponByIdAndMemberId(id, requestDto.getMemberId());
        if (existsCoupon) throw new RuntimeException("이미 발급 받은 쿠폰입니다.");
        Long createCouponId = couponRepository.save(Coupon.builder()
//              memberID로 보기
//                .id(requestDto.getId())
                .startTime(requestDto.getStartTime())
                .endTime(requestDto.getStartTime().plusDays(4))
                .codeType(requestDto.getCodeType())
                //item enum 순서 들어감
                .memberId(requestDto.getMemberId())
                .discount(requestDto.getDiscount())
                .usageStatus(requestDto.isUsageStatus())
                .overlap(requestDto.isOverlap())
                .item(requestDto.getItem())
                .build()).getId();
        return new ResponseEntity<>(createCouponId, HttpStatus.CREATED);
    }
    @Transactional
    public ResponseEntity<Long> deleteCoupon(Long id, Long memberId){
        couponRepository.deleteCouponByIdAndMemberId(id, memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    2
//    @Transactional
//    public ResponseEntity<String> useCoupon(Long id, CouponRequestDto requestDto){
//        LocalDateTime now = LocalDateTime.now();
//        Coupon coupon = couponRepository.findByIdAndMemberId(id, requestDto.getMemberId());
//
//        if(coupon.isUsageStatus()) {
//            return new ResponseEntity<>("이미 사용한 쿠폰입니다.", HttpStatus.BAD_REQUEST);
//        }
//        if (coupon.getEndTime().isAfter(now)){
//            return new ResponseEntity<>("사용 기간이 만료된 쿠폰입니다.", HttpStatus.BAD_REQUEST);
//        }
//        coupon.updateCoupon(true);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


//    3
    @Transactional
    public ResponseEntity<String> useCoupon(Long id, CouponRequestDto requestDto){
        LocalDateTime now = LocalDateTime.now();
        Optional<Coupon> coupon = Optional.ofNullable(couponRepository.findByIdAndMemberId(id, requestDto.getMemberId()));

        if (!coupon.isPresent()) {
            throw new RuntimeException("존재하지 않는 쿠폰입니다.");
        }

        Coupon c = coupon.get();
        if(c.isUsageStatus()) {
            return ResponseEntity.badRequest().body("이미 사용한 쿠폰입니다.");
        }

        if (c.getEndTime().isBefore(now)){
            return ResponseEntity.badRequest().body("사용 기간이 만료된 쿠폰입니다.");
        }

        c.updateCoupon(true);
        return ResponseEntity.ok().build();
    }
}
