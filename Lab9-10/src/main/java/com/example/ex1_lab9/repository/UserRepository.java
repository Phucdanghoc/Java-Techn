package com.example.ex1_lab9.repository;

import com.example.ex1_lab9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);


}
