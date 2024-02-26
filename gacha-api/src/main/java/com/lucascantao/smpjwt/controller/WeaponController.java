package com.lucascantao.smpjwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.WeaponModel;
import com.lucascantao.smpjwt.repository.WeaponRepository;

@RestController
@RequestMapping("/api/weapon")
public class WeaponController {

    @Autowired
    WeaponRepository weaponRepository;

    @GetMapping
    public ResponseEntity<List<WeaponModel>> listWeapon() {
        return ResponseEntity.ok().body(weaponRepository.findAll());
    }
    
}
