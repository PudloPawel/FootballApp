package com.example.footballapp.models.user;


import com.example.footballapp.security.permission.ApplicationUserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
@Builder
@ToString
public class UserDto {

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Username must be longer than 8 chars")
    private String login;

    @NotNull @NotBlank @Size(min = 8,message = "Password must be longer than 8 chars")
    private String password;

    @Email
    private String email;

    private ApplicationUserRole typeUser;

    public UserDto(String login, String password, String email, ApplicationUserRole typeUser) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.typeUser = Optional.ofNullable(typeUser)
                .orElse(ApplicationUserRole.USER);
    }
}
