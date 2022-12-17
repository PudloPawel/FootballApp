package com.example.footballapp.security.service;

import com.example.footballapp.security.data.dto.Token;
import com.example.footballapp.models.user.deserialize.UserLogin;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {

    Token login(UserLogin login) throws UsernameNotFoundException;

}
