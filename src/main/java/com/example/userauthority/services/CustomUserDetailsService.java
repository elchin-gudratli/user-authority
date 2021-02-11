package com.example.userauthority.services;


import com.example.userauthority.domain.Users;
import com.example.userauthority.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users ==null) {
            new UsernameNotFoundException("Users not found");
        }
        return users;
    }


    @Transactional
    public Users loadUserById(Long id){
        Users users = userRepository.getById(id);
        if(users ==null) {
            new UsernameNotFoundException("Users not found");
        }
        return users;

    }
}
