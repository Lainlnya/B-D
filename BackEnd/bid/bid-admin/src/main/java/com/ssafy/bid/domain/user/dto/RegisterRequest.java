package com.ssafy.bid.domain.user.dto;

import com.ssafy.bid.domain.user.Admin;
import lombok.Getter;

@Getter
public class RegisterRequest {
    private String id;
    private String password;
    private String confirmPassword;
    private String name;
    private String tel;
    private String schoolCode;
}