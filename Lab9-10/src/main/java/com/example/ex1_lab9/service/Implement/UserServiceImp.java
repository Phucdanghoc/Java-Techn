package com.example.ex1_lab9.service.Implement;

import com.example.ex1_lab9.repository.UserRepository;
import com.example.ex1_lab9.service.UserService;

import com.example.ex1_lab9.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Date;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Override
    public boolean CheckLogin(User user) {
        return false;
    }

    @Override
    public User authenticate(String email, String password) throws AuthenticationException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new AuthenticationException("Invalid credentials");
        }

        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new AuthenticationException("Invalid credentials");
        }

        return user;
    }

    @Override
    public String generateToken(User user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + (86400000)); // 24 hours
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
