package com.lucascantao.smpjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.dto.AuthResponseDTO;
import com.lucascantao.smpjwt.dto.LoginDTO;
import com.lucascantao.smpjwt.dto.RegisterDTO;
import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.UserRepository;
import com.lucascantao.smpjwt.security.JWTGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO login) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
        
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDTO register) {
        if (userRepository.existsByEmail(register.getEmail())) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));

        user = userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
    
}
