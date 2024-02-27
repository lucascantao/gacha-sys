package com.lucascantao.smpjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.PityModel;
import com.lucascantao.smpjwt.model.PityModelId;

public interface PityRepository extends JpaRepository<PityModel, PityModelId>{
    
    Optional<PityModel> findById(PityModelId id);

    boolean existsById(PityModelId id);

}
