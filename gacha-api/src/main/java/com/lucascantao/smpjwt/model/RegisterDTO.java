package com.lucascantao.smpjwt.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RegisterDTO {

    private String name;
    private String email;
    private String password;
    
}
