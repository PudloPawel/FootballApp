package com.example.footballapp.entity;

import com.example.footballapp.security.permission.ApplicationUserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.google.common.base.Objects;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS_ACCOUNT")
public class UsersEntity implements Serializable {

    @Builder
    public UsersEntity(Long id,
                       String login,
                       String password,
                       String email,
                       ApplicationUserRole typeUser,
                       String secretKey) {
        this.idUser = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createdAt = Instant.now();
        this.typeUser = Optional.ofNullable(typeUser)
                .orElse(ApplicationUserRole.USER);
        this.secretKey = secretKey;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER",
            unique = true)
    private Long idUser;

    @Column(name = "LOGIN")
    private String login;


    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TYPE_USER")
    private ApplicationUserRole typeUser;

    @Column(name = "secret_key",
            unique = true)
    private String secretKey;

    @Column(name = "created_at")
    private Instant createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity user = (UsersEntity) o;
        return Objects.equal(idUser, user.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUser);
    }
}

