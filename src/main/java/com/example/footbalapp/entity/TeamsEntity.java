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
@Table(name = "TEAMS")
public class TeamsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEAM")
    private Long idTeam;

    @Column(name = "NAME_CATEGORY_PL")
    private String nameCategoryPl;

    @Column(name = "NAME_CATEGORY_ENG")
    private String nameCategoryENG;

    @OneToMany(
            mappedBy = "idPlayer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayersEntity> players = new ArrayList<>();

    public TeamsEntity(String nameCategoryPl, String nameCategoryENG) {
        this.nameCategoryPl = nameCategoryPl;
        this.nameCategoryENG = nameCategoryENG;
    }

    public void setPlayers(List<PlayersEntity> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof TeamsEntity) {
            TeamsEntity otherTeam = (TeamsEntity) obj;

            return nameCategoryPl.equals(otherTeam.nameCategoryPl)
                    || nameCategoryENG.equals(otherTeam.nameCategoryENG);
        }
        return false;
    }

}
