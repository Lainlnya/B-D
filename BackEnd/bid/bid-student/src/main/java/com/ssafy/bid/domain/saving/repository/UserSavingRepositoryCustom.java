package com.ssafy.bid.domain.saving.repository;

import java.util.List;

import com.ssafy.bid.domain.saving.dto.SavingTransferAlertRequest;

public interface UserSavingRepositoryCustom {
	List<SavingTransferAlertRequest> findSavingTransferInfos();
}
