package com.example.jwt.service;


import com.example.jwt.model.entity.Users;

import java.util.List;

public interface UserService {
    Users findByUsername(String username);
    boolean existByUsername(String username);
    boolean existByEmail(String email);
    Users saveUser(Users users);
    List<Users> getAllUser();
    Users getUserById(int id);
    boolean deleteUser(Users user);
    Users updateUser(Users user);
    Users getUsersByUsername(String username);
}
