package com.example.jwt.service;

import com.example.jwt.model.entity.Role;

public interface RoleService {
    Role findRoleByRoleName(String roleName);
    boolean existsByRoleName(String roleName);
    Role findRoleById(int id);
}
