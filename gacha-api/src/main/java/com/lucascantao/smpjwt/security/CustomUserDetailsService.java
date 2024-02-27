package com.lucascantao.smpjwt.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucascantao.smpjwt.model.UserEntity;
import com.lucascantao.smpjwt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        Collection<GrantedAuthority> grantedAuthorities = Collections.emptyList();

        return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
    
}
