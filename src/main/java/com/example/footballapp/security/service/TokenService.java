package com.example.footballapp.security.service;

import com.example.footballapp.security.data.dto.Payload;
import com.example.footballapp.models.userDetails.CustomUserDetails;

public interface TokenService {

    String generateToken(CustomUserDetails payload);
    Payload getPayloadFromToken(String token);

}
