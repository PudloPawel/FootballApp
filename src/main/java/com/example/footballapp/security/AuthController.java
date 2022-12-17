package com.example.footballapp.security;

import com.example.footballapp.exception.ResourceNotFoundException;
import com.example.footballapp.models.user.deserialize.UserLogin;
import com.example.footballapp.security.data.dto.Token;
import com.example.footballapp.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Token> login(@Valid @RequestBody UserLogin userLogin) throws ResourceNotFoundException {

        return ResponseEntity.ok(authService.login(userLogin));
    }

}

