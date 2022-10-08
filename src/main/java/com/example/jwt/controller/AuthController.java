package com.example.jwt.controller;

import com.example.jwt.business.AuthBusiness;
import com.example.jwt.business.UserBusiness;
import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.controller.response.BaseResponse;
import com.example.jwt.controller.response.LoginResponse;
import com.example.jwt.jwt.JwtProvider;
import com.example.jwt.controller.request.SignInRequest;
import com.example.jwt.controller.request.SignUpRequest;
import com.example.jwt.controller.response.JwtResponse;
import com.example.jwt.controller.response.UserResponse;
import com.example.jwt.model.dto.UserDto;
import com.example.jwt.model.entity.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private AuthBusiness authBusiness;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody SignUpRequest request) {
        UserDto addUser = userBusiness.addUser(request);
        return new ResponseEntity<>(new UserResponse(UserErrorCode.SUCCESS, addUser), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody SignInRequest request) {
        UserDto userDto = authBusiness.login(request);
        String token = authBusiness.getToken(request);
       return new ResponseEntity<>(new LoginResponse(UserErrorCode.SUCCESS, userDto, token), HttpStatus.OK);
    }
}
