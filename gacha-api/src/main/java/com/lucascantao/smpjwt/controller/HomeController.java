package com.lucascantao.smpjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.CharacterModel;
import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.BannerRepository;
import com.lucascantao.smpjwt.repository.CharacterRepository;
import com.lucascantao.smpjwt.repository.UserRepository;
import com.lucascantao.smpjwt.security.JWTGenerator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    JWTGenerator jwtGenerator;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BannerRepository bannerRepository;

    @Autowired
    CharacterRepository characterRepository;
    

    @GetMapping("/hello")
    public String hello() {
        return "Hello Would!";
    }

    @PostMapping("/pull-banner/{id}/{option}")
    public void addPulls(
        HttpServletRequest request,
        @RequestParam int bannerId,
        @RequestParam int option) {

        String username = jwtGenerator.getUsernameFromJWT(request.getHeader("Authorization").split(" ")[1]);
        UserEntity usuario = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        
        List<CharacterModel> character = bannerRepository.findById(bannerId).getCharacters();

        usuario.getCharacters().add(null);

        userRepository.save(usuario);

    }
    
}
