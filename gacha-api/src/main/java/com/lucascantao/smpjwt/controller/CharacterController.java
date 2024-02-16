package com.lucascantao.smpjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.CharacterModel;
import com.lucascantao.smpjwt.repository.CharacterRepository;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping
    public ResponseEntity<List<CharacterModel>> listCharacter() {
        List<CharacterModel> charList = characterRepository.findAll();
        return ResponseEntity.ok().body(charList);
    }

}
