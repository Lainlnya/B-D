package com.ssafy.bid.domain.coupon.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bid.domain.coupon.Coupon;
import com.ssafy.bid.domain.coupon.CouponStatus;
import com.ssafy.bid.domain.coupon.dto.CouponListResponse;
import com.ssafy.bid.domain.coupon.dto.UserCouponResponse;
import com.ssafy.bid.domain.coupon.repository.CouponRepository;
import com.ssafy.bid.domain.coupon.repository.UserCouponRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {

	private final CouponRepository couponRepository;
	private final UserCouponRepository userCouponRepository;

	@Transactional(readOnly = true)
	public CouponListResponse findCoupons(int gradeNo) {
		List<Coupon> registeredCoupons = couponRepository
			.findByGradeNoAndCouponStatus(gradeNo, CouponStatus.REGISTERED);

		List<Coupon> unregisteredCoupons = couponRepository
			.findByGradeNoAndCouponStatus(gradeNo, CouponStatus.UNREGISTERED);

		return new CouponListResponse(registeredCoupons, unregisteredCoupons);
	}

	@Transactional(readOnly = true)
	public List<UserCouponResponse> findCouponRequests(int gradeNo) {
		return userCouponRepository.findUserCouponList(gradeNo);
	}

	public void acceptCoupon(int couponNo) {
		Coupon coupon = couponRepository.findById(couponNo)
			.orElseThrow(() -> new NoSuchElementException("쿠폰이 없습니다."));

		coupon.accept();
	}

	public void deleteCoupon(int couponNo) {
		if (!couponRepository.existsById(couponNo)) {
			throw new EntityNotFoundException("쿠폰이 없습니다.");
		}
		couponRepository.deleteById(couponNo);
	}


}
