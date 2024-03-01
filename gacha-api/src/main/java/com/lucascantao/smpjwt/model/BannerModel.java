package com.lucascantao.smpjwt.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banner")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "banner_characters",
        joinColumns = @JoinColumn(name = "banner_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id")
    )
    @Builder.Default
    private List<CharacterModel> characters = new ArrayList<>();


}
