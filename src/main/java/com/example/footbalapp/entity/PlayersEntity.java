package com.example.footbalapp.entity;

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
public class PlayersEntity {

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

    @Column(name = "NUMBER")
    private Long numberPlayer;

    @ManyToMany(mappedBy = "players")
    private List<TeamsEntity> team = new ArrayList<>();


    public PlayersEntity(String name, String surname, String dateOfBirth, String position, Long numberPlayer) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.numberPlayer = numberPlayer;
    }

    public void addTeam(TeamsEntity teamsEntity){
        team.add(teamsEntity);
    }
}

