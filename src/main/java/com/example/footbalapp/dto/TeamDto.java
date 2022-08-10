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

    private String nameTeamPl;
    private String nameTeamEng;

    public TeamDto(String nameTeamPl, String nameTeamEng) {
        this.nameTeamPl = nameTeamPl;
        this.nameTeamEng = nameTeamEng;
    }
}
