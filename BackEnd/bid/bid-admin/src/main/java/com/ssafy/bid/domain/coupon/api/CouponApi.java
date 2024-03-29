package com.ssafy.bid.domain.coupon.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bid.domain.coupon.dto.CouponListResponse;
import com.ssafy.bid.domain.coupon.service.CouponService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CouponApi {

	private final CouponService couponService;

	@GetMapping("/{gradeNo}/coupons")
	public ResponseEntity<CouponListResponse> findCoupons(@PathVariable int gradeNo) {
		return ResponseEntity.ok(couponService.findCoupons(gradeNo));
	}

	@PatchMapping("/{gradeNo}/coupons/{couponNo}")
	public void acceptCoupon(@PathVariable int gradeNo, @PathVariable int couponNo) {
		couponService.acceptCoupon(couponNo);
	}

	@DeleteMapping("/{gradeNo}/coupons/{couponNo}")
	public void deleteCoupon(@PathVariable int gradeNo, @PathVariable int couponNo) {
		couponService.deleteCoupon(couponNo);
	}

	@PatchMapping("/{gradeNo}/coupons/{couponNo}/register")
	public ResponseEntity<?> registerCoupon(@PathVariable int gradeNo, @PathVariable int couponNo){
		couponService.registerCoupon(couponNo);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{gradeNo}/coupons/{couponNo}/unregister")
	public ResponseEntity<?> unRegisterCoupon(@PathVariable int gradeNo, @PathVariable int couponNo){
		couponService.unRegisterCoupon(couponNo);
		return ResponseEntity.noContent().build();
	}
}
