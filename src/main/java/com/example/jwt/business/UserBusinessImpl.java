package com.example.jwt.business;

import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.controller.request.SignUpRequest;
import com.example.jwt.controller.request.UpdateRequest;
import com.example.jwt.exception.UserRestApiException;
import com.example.jwt.middleware.UserVerifyRequestServices;
import com.example.jwt.model.dto.UserDto;
import com.example.jwt.model.entity.Role;
import com.example.jwt.model.entity.Users;
import com.example.jwt.service.RoleService;
import com.example.jwt.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserBusinessImpl implements UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserVerifyRequestServices userVerifyRequestServices;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<>();
        List<Users> users = userService.getAllUser();
        users.forEach(user-> {
            userDtos.add(convertUsersToUserDto(user));
        });
        return userDtos;
    }

    @Override
    public UserDto getUSer(int id) {
        Users user = userService.getUserById(id);
        return convertUsersToUserDto(user);
    }

    @Override
    public boolean deleteUser(int id) {
        Users user = userService.getUserById(id);
        return userService.deleteUser(user);
    }

    @Override
    public UserDto addUser(SignUpRequest request) {
        userVerifyRequestServices.verifyAddUserRequest(request);
        if(userService.existByEmail(request.getEmail())) {
           throw new UserRestApiException(UserErrorCode.EMAIL_EXISTED);
        }
        if(userService.existByUsername(request.getUsername())) {
            throw new UserRestApiException(UserErrorCode.USERNAME_EXISTED);
        }
        Set<Role> roleSet =new  HashSet<>();
        if(request.getRoles().size() > 0) {
            for(String role : request.getRoles()) {
                Role newRole;
                if(roleService.existsByRoleName(role)) {
                    newRole = roleService.findRoleByRoleName(role);
                    roleSet.add(newRole);
                }
            }
        }
        Users user = new Users();
        user.setRoles(roleSet);
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.saveUser(user);
        return convertUsersToUserDto(user);
    }

    @Override
    public UserDto updateUser(int id, UpdateRequest request) {
        return null;
    }
    @Override
    public UserDto convertUsersToUserDto(Users users) {
        if (users == null) return null;
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserDto userDto = modelMapper.map(users, UserDto.class);
            return userDto;
        } catch (Exception e) {
            return null;
        }
    }
}
