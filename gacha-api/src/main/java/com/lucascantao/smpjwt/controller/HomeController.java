package com.lucascantao.smpjwt.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    /**
     * 
     * @param request user information
     * @param bannerId banner to pull from
     * @param option quantity of pulls to use
     */
    @PostMapping("/pull")
    public ResponseEntity<CharacterModel> addPulls(
        HttpServletRequest request,
        @RequestParam int bannerId,
        @RequestParam int option) {

        String username = jwtGenerator.getUsernameFromJWT(request.getHeader("Authorization").split(" ")[1]);
        UserEntity usuario = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        Random rand = new Random();
        
        List<CharacterModel> characterList = bannerRepository.findById(bannerId).getCharacters();

        Integer pull = rand.nextInt(characterList.size());

        CharacterModel character = characterList.get(pull);

        usuario.getCharacters().add(character);

        userRepository.save(usuario);

        return ResponseEntity.ok().body(character);

    }
    
}
