package com.example.footbalapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PLAYER_OF_TEAM")
public class PlayerOfTeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_PLAYER")
    private PlayersEntity playersEntity;

    @ManyToOne
    @JoinColumn(name="ID_TEAM")
    private TeamsEntity teamsEntity;

    public void setPlayer(PlayersEntity playersEntity) {
        this.playersEntity = playersEntity;
    }

    public void setTeam(TeamsEntity teamsEntity) {
        this.teamsEntity = teamsEntity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof PlayerOfTeamEntity) {
            PlayerOfTeamEntity playersOfTeam = (PlayerOfTeamEntity) obj;
            return playersEntity.getIdPlayer().equals(playersOfTeam.getPlayersEntity()) &&
                    teamsEntity.getIdTeam().equals(playersOfTeam.getTeamsEntity());
        }
        return false;
    }

}
