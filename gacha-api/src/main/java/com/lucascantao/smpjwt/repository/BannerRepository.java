package com.lucascantao.smpjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascantao.smpjwt.model.BannerModel;

public interface BannerRepository extends JpaRepository<BannerModel, Integer> {

    BannerModel findById(int id);

    boolean existsByName(String name);

}
