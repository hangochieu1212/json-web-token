package com.example.jwt.repository;

import com.example.jwt.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Users getUsersById(int id);
    Users getUsersByUsername(String username);
}
