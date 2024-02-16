package com.lucascantao.smpjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.BannerModel;
import com.lucascantao.smpjwt.model.CharacterModel;
import com.lucascantao.smpjwt.repository.BannerRepository;
import com.lucascantao.smpjwt.repository.CharacterRepository;

@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    BannerRepository bannerRepository;

    @GetMapping("/add")
    public ResponseEntity<String> addCharacter(@RequestParam int banner_id, @RequestParam String character_name) {
        BannerModel banner = bannerRepository.findById(banner_id);
        CharacterModel character = characterRepository.findByName(character_name);
        banner.getCharacters().add(character);
        bannerRepository.save(banner);

        return ResponseEntity.ok("Ok");
    }
    
}
