package com.example.jwt.model.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto extends BaseModelDto {
    private String roleName;
    @JsonIncludeProperties({"id","username"})
    private List<UserDto> users;
}
