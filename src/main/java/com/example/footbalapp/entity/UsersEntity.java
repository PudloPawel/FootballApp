package com.example.footbalapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS_ACCOUNT")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TYPE_USER")
    private String typeUser;

    public UsersEntity(String login, String password, String email, String typeUser) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.typeUser = typeUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(typeUser, that.typeUser);
    }

}

