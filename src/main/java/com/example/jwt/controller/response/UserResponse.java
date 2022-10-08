package com.example.jwt.controller.response;

import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.model.dto.BaseModelDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse {
    @JsonProperty(value = "user")
    private BaseModelDto userDto;

    public UserResponse(UserErrorCode errorCode, BaseModelDto userDto) {
        super(errorCode);
        this.userDto = userDto;
    }
}
