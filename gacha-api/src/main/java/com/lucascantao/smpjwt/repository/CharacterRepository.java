package com.lucascantao.smpjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.CharacterModel;

public interface CharacterRepository extends JpaRepository<CharacterModel, Integer> {

    CharacterModel findById(int id);

    CharacterModel findByName(String name);

}
