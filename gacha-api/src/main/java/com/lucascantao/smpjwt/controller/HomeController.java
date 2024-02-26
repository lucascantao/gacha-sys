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
import com.lucascantao.smpjwt.model.PityModel;
import com.lucascantao.smpjwt.model.PityModelId;
import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.BannerRepository;
import com.lucascantao.smpjwt.repository.CharacterRepository;
import com.lucascantao.smpjwt.repository.PityRepository;
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

    @Autowired
    PityRepository pityRepository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Would!";
    }

    /**
     * 
     * @param request  user information
     * @param bannerId banner to pull from
     * @param option   quantity of pulls to use
     */
    @PostMapping("/pull")
    public ResponseEntity<List<CharacterModel>> addPulls(
            HttpServletRequest request,
            @RequestParam int bannerId,
            @RequestParam int option) {

        String username = jwtGenerator.getUsernameFromJWT(request.getHeader("Authorization").split(" ")[1]);
        UserEntity usuario = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        PityModel pity = pityRepository.findById(PityModelId.builder().bannerId(bannerId).userId(usuario.getId()).build()).orElseThrow();

        if (usuario.getPulls() < option) {
            return ResponseEntity.badRequest().body(null);
        }

        List<CharacterModel> resultList = new ArrayList<>();

        for (int i = 0; i < option; i++) {

            pity.setT4Pity(pity.getT4Pity() + 1);
            pity.setT5Pity(pity.getT5Pity() + 1);

            List<CharacterModel> characterList = bannerRepository.findById(bannerId).getCharacters();
            CharacterModel character = null;

            SplittableRandom random = new SplittableRandom();
            boolean t5probability = random.nextInt(100) == 0;
            boolean t4probability = random.nextInt(100) == 0;

            List<CharacterModel> t5 = characterList.stream().filter(c -> c.getTier() == 5).collect(Collectors.toList());
            List<CharacterModel> t4 = characterList.stream().filter(c -> c.getTier() == 4).collect(Collectors.toList());

            if (t5probability || pity.getT5Pity() >= 90) {
                character = t5.get(0);
                pity.setT5Pity(0);
            } else if (t4probability || pity.getT4Pity() >= 10) {
                character = t4.get(random.nextInt(t4.size()));
                pity.setT4Pity(0);
            } else {
                character = characterRepository.findByName("Qiqi");
            }

            usuario.getCharacters().add(character);
            resultList.add(character);
            usuario.setPulls(usuario.getPulls() - 1);
        }

        userRepository.save(usuario);
        pityRepository.save(pity);

        return ResponseEntity.ok().body(resultList);

    }

}
