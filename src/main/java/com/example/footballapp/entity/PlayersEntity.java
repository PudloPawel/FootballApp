package com.example.footballapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PLAYERS")
public class PlayersEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLAYER")
    private Long idPlayer;

    @Column(name = "NAME_PLAYER")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth; //zmień na typ Date

    @Column(name = "POSITION")
    private String position;

    @OneToMany(
            mappedBy = "idTeam",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeamsEntity> teams = new ArrayList<>();

    public PlayersEntity(String name, String surname, String dateOfBirth, String position) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

    public void setTeams(List<TeamsEntity> teams) {
        this.teams = teams;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof PlayersEntity) {
            PlayersEntity otherPlayer = (PlayersEntity) obj;
            return name.equals(otherPlayer.name) &&
                    surname.equals(otherPlayer.surname) &&
                    dateOfBirth.equals(otherPlayer.dateOfBirth) &&
                    position.equals(otherPlayer.position);
        }
        return false;
    }

}

