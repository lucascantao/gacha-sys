package com.lucascantao.smpjwt.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PityModelId {

    private Integer userId;
    
    private Integer bannerId;
    
}
