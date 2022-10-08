package com.example.jwt.controller.response;

import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse extends BaseResponse {
    @JsonProperty(value = "user")
    private UserDto userDto;
    private String token;

    public LoginResponse(UserErrorCode errorCode, UserDto userDto, String token) {
        super(errorCode);
        this.userDto = userDto;
        this.token = token;
    }
}
