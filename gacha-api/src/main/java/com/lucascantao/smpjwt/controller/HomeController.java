package com.lucascantao.smpjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("v1/api/home")
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Would!";
    }

    @PostMapping("/pull-banner/{id}/{option}")
    public void addPulls(
        HttpServletRequest request,
        @RequestParam int bannerId, 
        @RequestParam int option) {


    }
    
}
