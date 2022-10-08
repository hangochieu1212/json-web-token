package com.example.jwt.business;

import com.example.jwt.controller.request.SignInRequest;
import com.example.jwt.jwt.JwtProvider;
import com.example.jwt.model.dto.UserDto;
import com.example.jwt.model.entity.Users;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthBusinessImpl implements AuthBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private UserBusiness userBusiness;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public String getToken(SignInRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtProvider.createToken(authentication);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public UserDto login(SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Users user = userService.getUsersByUsername(request.getUsername());
        return userBusiness.convertUsersToUserDto(user);
    }
}
