package com.example.footballapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlayerForTeamDto {

    private Long idPlayer;
    private Long idTeam;

}
