package com.example.footballapp.security.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Token {

    private final String token;

    @Builder
    public Token(String token) {
        this.token = token;
    }

}
