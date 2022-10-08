package com.example.jwt.business;

import com.example.jwt.controller.request.UpdateRequest;
import com.example.jwt.model.dto.UserDto;
import com.example.jwt.controller.request.SignUpRequest;
import com.example.jwt.model.entity.Users;

import java.util.List;

public interface UserBusiness {
    List<UserDto> getAllUser();
    UserDto getUSer(int id);
    boolean deleteUser(int id);
    UserDto addUser(SignUpRequest request);
    UserDto updateUser(int id, UpdateRequest request);
    UserDto convertUsersToUserDto(Users users);
}
