package com.example.userauthority.services;



import com.example.userauthority.domain.Users;
import com.example.userauthority.exceptions.UsernameAlreadyExistsException;
import com.example.userauthority.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users saveUser (Users newUsers){

        try{
            newUsers.setPassword(bCryptPasswordEncoder.encode(newUsers.getPassword()));

            newUsers.setUsername(newUsers.getUsername());

            newUsers.setConfirmPassword("");

            return userRepository.save(newUsers);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+ newUsers.getUsername()+"' already exists");
        }

    }



}
