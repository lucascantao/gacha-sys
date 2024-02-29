package com.lucascantao.smpjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.UserRepository;
import com.lucascantao.smpjwt.security.JWTGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserContoller {

    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JWTGenerator jwtGenerator;

    @GetMapping("/getUserToken")
    public ResponseEntity<UserEntity> getUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization").split(" ")[1];
        String username = jwtGenerator.getUsernameFromJWT(token);
        UserEntity user = userRepository.findByEmail(username).orElseThrow();
        if(user!=null){
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.badRequest().body(null);
    }
    
}
