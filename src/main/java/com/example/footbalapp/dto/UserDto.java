package com.example.footbalapp.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserDto {

    private String login;
    private String password;
    private String email;
    private String typeUser;



}
