package com.lucascantao.smpjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String username);
    boolean  existsByEmail(String email);
    
}
