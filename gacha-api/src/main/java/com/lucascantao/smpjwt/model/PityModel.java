package com.lucascantao.smpjwt.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pity")
public class PityModel {
    
    @EmbeddedId
    PityModelId id;

    Integer t5Pity;

    Integer t4Pity;

}
