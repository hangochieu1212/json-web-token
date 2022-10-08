package com.example.jwt.repository;

import com.example.jwt.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByRoleName(String roleName);
    boolean existsByRoleName(String roleName);
    Role findRoleById(int id);
}
