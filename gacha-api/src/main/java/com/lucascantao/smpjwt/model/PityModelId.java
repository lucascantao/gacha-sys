package com.lucascantao.smpjwt.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PityModelId {

    private Integer userId;
    
    private Integer bannerId;
    
}
