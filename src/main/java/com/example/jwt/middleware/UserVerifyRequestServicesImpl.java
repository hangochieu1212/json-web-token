package com.example.jwt.middleware;

import com.example.jwt.constant.AuthErrorCode;
import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.controller.request.SignUpRequest;
import com.example.jwt.controller.request.UpdateRequest;
import com.example.jwt.exception.UserRestApiException;
import com.example.jwt.util.ValidateField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserVerifyRequestServicesImpl implements UserVerifyRequestServices {
    @Autowired
    private ValidateField validateField;
    @Override
    public void verifyAddUserRequest(SignUpRequest request) {
        String name = request.getName();
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        Set<String> roles =request.getRoles();

        if (name == null || name.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_FULLNAME_FIELD);
        }
        if (email == null || email.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_EMAIL_FIELD);
        }
        if (username == null || username.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new UserRestApiException(AuthErrorCode.MISSING_PASSWORD_FIELD);
        }
        if (!validateField.validEmail(email)) {
            throw new UserRestApiException(UserErrorCode.EMAIL_INVALID);
        }
        if (!validateField.validPassword(password)) {
            throw new UserRestApiException(AuthErrorCode.PASSWORD_INVALID);
        }
        if (!validateField.validUsername(username)) {
            throw new UserRestApiException(AuthErrorCode.USERNAME_INVALID);
        }
    }

    @Override
    public void verifyUpdateUserRequest(UpdateRequest request) {
        String name = request.getName();
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        if (name == null || name.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_FULLNAME_FIELD);
        }
        if (email == null || email.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_EMAIL_FIELD);
        }
        if (username == null || username.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new UserRestApiException(AuthErrorCode.MISSING_PASSWORD_FIELD);
        }
        if (!validateField.validEmail(email)) {
            throw new UserRestApiException(UserErrorCode.EMAIL_INVALID);
        }
        if (!validateField.validPassword(password)) {
            throw new UserRestApiException(AuthErrorCode.PASSWORD_INVALID);
        }
    }
}
