package com.lucascantao.smpjwt.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireAt = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        String token = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(expireAt)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();

            return token;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
                
    }

    public boolean validateToken(String token) {
        try {

            Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
            return true;

        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect", ex.fillInStackTrace());
        }
    }
    
}
