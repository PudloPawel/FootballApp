package com.example.footballapp.models.user.deserialize;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    @NotBlank(message = "login")
    private String login;

    @NotBlank(message = "Password should not be empty")
    private String password;

}
