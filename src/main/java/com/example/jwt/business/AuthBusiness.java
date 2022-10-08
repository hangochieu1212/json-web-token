package com.example.jwt.business;

import com.example.jwt.controller.request.SignInRequest;
import com.example.jwt.model.dto.UserDto;

public interface AuthBusiness {
    String getToken (SignInRequest request);

    UserDto login(SignInRequest request);
}
