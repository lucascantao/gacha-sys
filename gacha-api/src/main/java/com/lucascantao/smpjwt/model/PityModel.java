package com.lucascantao.smpjwt.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pity")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PityModel {
    
    @EmbeddedId
    PityModelId id;

    Integer t5Pity;

    Integer t4Pity;

}
