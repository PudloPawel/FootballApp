package com.example.footbalapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PLAYERS_TEAM")
public class PlayersTeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_PLAYER")
    private Long idPlayer;

    @Column(name = "ID_TEAM")
    private Long idTeam;

    public PlayersTeamEntity(Long idPlayer, Long idTeam) {
        this.idPlayer = idPlayer;
        this.idTeam = idTeam;
    }
}

