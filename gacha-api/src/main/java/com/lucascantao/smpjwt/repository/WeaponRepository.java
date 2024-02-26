package com.lucascantao.smpjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.WeaponModel;

public interface WeaponRepository extends JpaRepository<WeaponModel, Long>{
    
    Optional<WeaponModel> findById(Long id);

}
