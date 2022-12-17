package com.example.footballapp.models.functionDto;

import com.example.footballapp.models.PlayerForTeamDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChangePlayerInTheTeamDto {

    private Long idPlayerInTeam;
    private PlayerForTeamDto playerForTeamDto;
    private Status.Validation status;
    private String message;

}
