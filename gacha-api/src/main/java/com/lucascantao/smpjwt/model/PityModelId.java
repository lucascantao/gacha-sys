package com.lucascantao.smpjwt.model;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder
public class PityModelId {

    private Integer userId;
    
    private Integer bannerId;
    
}
