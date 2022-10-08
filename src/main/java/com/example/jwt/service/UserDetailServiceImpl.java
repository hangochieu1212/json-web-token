package com.example.jwt.service;
import com.example.jwt.model.entity.Users;
import com.example.jwt.model.entity.UserDetailImpl;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.existsByUsername(username)) {
            Users users = userRepository.findByUsername(username);
            return UserDetailImpl.build(users);
        }
        else {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
    }
}
