package com.lucascantao.smpjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.CharacterModel;

public interface CharacterRepository extends JpaRepository<CharacterModel, Integer>{
    
    Optional<CharacterModel> findById(int id);

}
