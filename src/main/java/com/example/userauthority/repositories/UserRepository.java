package com.example.userauthority.repositories;


import com.example.userauthority.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {


    Users findByUsername(String username);
    Users getById(Long id);
}
