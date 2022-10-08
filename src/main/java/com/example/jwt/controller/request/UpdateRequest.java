package com.example.jwt.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
