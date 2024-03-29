package com.lucascantao.smpjwt.dto;

import java.util.List;

import com.lucascantao.smpjwt.model.CharacterModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerDTO {

    private String name;
    private List<CharacterModel> characters;
    
}
