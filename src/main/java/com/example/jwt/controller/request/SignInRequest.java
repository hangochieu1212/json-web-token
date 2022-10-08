package com.example.jwt.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class SignInRequest {
    private String username;
    private String password;
}
