package com.lucascantao.smpjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.dto.BannerDTO;
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

    @GetMapping
    public ResponseEntity<List<BannerModel>> listBanner() {
        List<BannerModel> bannerList = bannerRepository.findAll();
        return ResponseEntity.ok().body(bannerList);
    }

    @PostMapping
    public ResponseEntity<BannerModel> createBanner(@RequestBody BannerDTO banner) {
        if (!bannerRepository.existsByName(banner.getName())) {
            BannerModel model = new BannerModel();
            model.setName(banner.getName());
            for(CharacterModel c: banner.getCharacters()){
                model.getCharacters().add(c);
            }
            model = bannerRepository.save(model);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
