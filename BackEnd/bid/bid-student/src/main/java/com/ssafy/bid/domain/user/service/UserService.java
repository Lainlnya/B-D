package com.ssafy.bid.domain.user.service;

import java.util.List;

import com.ssafy.bid.domain.user.dto.AccountRequest;
import com.ssafy.bid.domain.user.dto.AccountResponse;
import com.ssafy.bid.domain.user.dto.StudentRequest;
import com.ssafy.bid.domain.user.dto.StudentResponse;

public interface UserService {

	StudentResponse findStudent(int userNo, StudentRequest studentRequest);

	List<AccountResponse> findAccount(int userNo, AccountRequest accountRequest);
}
