package com.example.ex1_lab9.service;
import com.example.ex1_lab9.model.User;

import javax.naming.AuthenticationException;

public interface UserService {

   boolean CheckLogin(User user);

   User authenticate(String email,String password) throws AuthenticationException;

   String generateToken(User user);
   public Long getUserIdFromToken(String token);

   User save(User user);
}
