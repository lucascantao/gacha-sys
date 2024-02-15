package com.lucascantao.smpjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/home")
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Would!";
    }
    
}
