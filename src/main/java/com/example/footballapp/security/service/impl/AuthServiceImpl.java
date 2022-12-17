package com.example.footballapp.security.service.impl;

import com.example.footballapp.exception.InvalidPasswordException;
import com.example.footballapp.exception.ResourceNotFoundException;
import com.example.footballapp.security.data.dto.Token;
import com.example.footballapp.models.user.deserialize.UserLogin;
import com.example.footballapp.models.userDetails.CustomUserDetails;
import com.example.footballapp.security.service.AuthService;
import com.example.footballapp.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    @Override
    public Token login(UserLogin userLogin) throws ResourceNotFoundException,InvalidPasswordException {

        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService
                .loadUserByUsername(userLogin.getLogin());

        if (!passwordEncoder.matches(userLogin.getPassword(),
                userDetails.getPassword())){
            throw new InvalidPasswordException();
        }

        return new Token(tokenService.generateToken(userDetails));

    }

}
