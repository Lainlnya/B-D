package com.ssafy.bid.domain.saving.repository;

import static com.ssafy.bid.domain.grade.QGrade.*;
import static com.ssafy.bid.domain.saving.QSaving.*;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.bid.domain.saving.dto.SavingFindResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoreSavingRepositoryCustomImpl implements CoreSavingRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<SavingFindResponse> findAllSavingByGradeNo(int gradeNo) {
		return queryFactory
			.select(Projections.constructor(SavingFindResponse.class,
					grade.asset,
					saving.no,
					saving.name,
					saving.depositPeriod,
					saving.depositCycle,
					saving.depositPrice,
					saving.interestRate,
					saving.terms
				)
			)
			.from(saving)
			.innerJoin(grade).on(grade.no.eq(saving.gradeNo))
			.where(
				grade.no.eq(gradeNo),
				grade.deletedAt.isNull()
			)
			.fetch();
	}
}
