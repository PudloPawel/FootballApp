package com.example.footbalapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TeamDto {

    private Long idTeam;
    private String nameTeam;

    public TeamDto(Long idTeam, String nameTeam) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
    }

    public TeamDto(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
