package com.example.jwt.middleware;

import com.example.jwt.controller.request.SignInRequest;
import com.example.jwt.controller.request.SignUpRequest;
import com.example.jwt.controller.request.UpdateRequest;

public interface UserVerifyRequestServices {
    void verifyAddUserRequest(SignUpRequest request);
    void verifyUpdateUserRequest(UpdateRequest request);

}
