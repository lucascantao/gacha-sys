package com.lucascantao.smpjwt.publico.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.UserRepository;

@RestController
@RequestMapping("/api/publico/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<UserEntity> getUser(@RequestParam Integer id) {
        UserEntity user = this.userRepository.findById(id).orElseThrow();
        if (user!=null){
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.badRequest().body(null);
        
    }
    
}
