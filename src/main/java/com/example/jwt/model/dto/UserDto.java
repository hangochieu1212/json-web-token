package com.example.jwt.model.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class UserDto extends BaseModelDto {
    private String name;
    private String email;
    private String username;
    private String password;
    @JsonIncludeProperties({"id","roleName"})
    private List<RoleDto> roles;
}
