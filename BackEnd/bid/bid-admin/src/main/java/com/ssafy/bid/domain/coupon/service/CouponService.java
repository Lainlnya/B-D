package com.ssafy.bid.domain.coupon.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bid.domain.coupon.Coupon;
import com.ssafy.bid.domain.coupon.CouponStatus;
import com.ssafy.bid.domain.coupon.UserCoupon;
import com.ssafy.bid.domain.coupon.dto.CouponListResponse;
import com.ssafy.bid.domain.coupon.dto.CouponResponse;
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
		List<CouponResponse> registeredCoupons = couponRepository
			.findByGradeNoAndCouponStatus(gradeNo, CouponStatus.REGISTERED)
			.stream()
			.map(coupon -> CouponResponse.builder()
				.no(coupon.getNo())
				.name(coupon.getName())
				.description(coupon.getDescription())
				.gradeNo(coupon.getGradeNo())
				.build()
			).toList();

		List<CouponResponse> unregisteredCoupons = couponRepository
			.findByGradeNoAndCouponStatus(gradeNo, CouponStatus.UNREGISTERED)
			.stream()
			.map(coupon -> CouponResponse.builder()
				.no(coupon.getNo())
				.name(coupon.getName())
				.description(coupon.getDescription())
				.gradeNo(coupon.getGradeNo())
				.build()
			).toList();

		return new CouponListResponse(registeredCoupons, unregisteredCoupons);
	}

	@Transactional(readOnly = true)
	public List<UserCouponResponse> findUserCoupons(int gradeNo) {
		return userCouponRepository.findUserCoupons(gradeNo);
	}

	public void acceptUserCoupon(long userCouponNo) {
		if (!userCouponRepository.existsById(userCouponNo)) {
			throw new EntityNotFoundException("쿠폰이 없습니다.");
		}
		// Todo. 해당 학생 알림 주기
		userCouponRepository.deleteById(userCouponNo);
	}

	public void rejectUserCoupon(long userCouponNo) {
		UserCoupon userCoupon = userCouponRepository.findById(userCouponNo)
			.orElseThrow(() -> new NoSuchElementException("쿠폰이 없습니다."));

		userCoupon.reject();
	}

	public void registerCoupon(int couponNo) {
		Coupon coupon = couponRepository.findById(couponNo)
			.orElseThrow(() -> new NoSuchElementException("쿠폰이 없습니다."));

		coupon.register();
	}

	public void unRegisterCoupon(int couponNo) {
		Coupon coupon = couponRepository.findById(couponNo)
			.orElseThrow(() -> new NoSuchElementException("쿠폰이 없습니다."));

		coupon.unRegister();
	}
}
