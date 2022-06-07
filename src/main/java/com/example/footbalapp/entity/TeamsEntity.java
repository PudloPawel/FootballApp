package com.example.footbalapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public TeamsEntity(String nameCategoryPl, String nameCategoryENG) {
        this.nameCategoryPl = nameCategoryPl;
        this.nameCategoryENG = nameCategoryENG;
    }
}
