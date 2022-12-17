package com.example.footballapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamDto {

    private String nameTeamPl;
    private String nameTeamEng;

}
