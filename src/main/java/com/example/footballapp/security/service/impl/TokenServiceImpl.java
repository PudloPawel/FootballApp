package com.example.footballapp.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.footballapp.security.config.JwtConfig;
import com.example.footballapp.security.data.dto.Payload;
import com.example.footballapp.models.userDetails.CustomUserDetails;
import com.example.footballapp.security.service.TokenService;




import java.time.Instant;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Component
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final JwtConfig jwtConfig;

    @Override
    public String generateToken(CustomUserDetails payload) {

        return Jwts.builder()
                .setSubject(payload.getUsername())
                .claim("id",payload.getId())
                .claim("secret",payload.getSecretKey())
                .setExpiration(Date.from(Instant.now()
                    .plusSeconds(jwtConfig.getTokenExpiration())))
                .signWith(HS256, jwtConfig.getSecretKey().getBytes())
                .compact();
    }

    @Override
    public Payload getPayloadFromToken(String token) {

        Claims body = Jwts.parser()
                .setSigningKey(jwtConfig.getSecretKey().getBytes())
                .parseClaimsJws(token)
                .getBody();

        return Payload.builder()
                .id(Long.parseLong(body.get("id").toString()))
                .username(body.getSubject())
                .secret(body.get("secret").toString())
                .build();
    }
}
