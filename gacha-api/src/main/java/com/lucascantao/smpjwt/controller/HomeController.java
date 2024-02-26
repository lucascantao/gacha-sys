package com.lucascantao.smpjwt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<CharacterModel>> addPulls(
        HttpServletRequest request,
        @RequestParam int bannerId,
        @RequestParam int option) {

        String username = jwtGenerator.getUsernameFromJWT(request.getHeader("Authorization").split(" ")[1]);
        UserEntity usuario = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        if(usuario.getPulls() < option){
            return ResponseEntity.badRequest().body(null);
        }

        List<CharacterModel> resultList = new ArrayList<>();

        for(int i = 0; i < option; i++) {
            List<CharacterModel> characterList = bannerRepository.findById(bannerId).getCharacters();
            CharacterModel character = getCharacterProbability(characterList);
            resultList.add(character);
            if(!usuario.getCharacters().contains(character))
                usuario.getCharacters().add(character);
            usuario.setPulls(usuario.getPulls() - 1);
        }
        userRepository.save(usuario);

        return ResponseEntity.ok().body(resultList);

    }

    private CharacterModel getCharacterProbability(List<CharacterModel> list) {
        SplittableRandom random = new SplittableRandom();
        boolean t5probability = random.nextInt(100)==0;
        
        if(t5probability)
            return list.stream().filter(character -> character.getTier()==5).collect(Collectors.toList()).get(0);
        return list.stream().filter(character -> character.getTier()==4).collect(Collectors.toList()).get(random.nextInt(list.size() - 1));
    }
    
}
