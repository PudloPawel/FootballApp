package com.example.footbalapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PlayerForTeamDto {

    private Long idPlayer;
    private Long idTeam;

    public PlayerForTeamDto(Long idPlayer, Long idTeam) {
        this.idPlayer = idPlayer;
        this.idTeam = idTeam;
    }
}
