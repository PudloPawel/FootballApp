package com.example.footballapp.models.functionDto;

import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddTeamDto {

    private Long idTeam;
    private TeamDto teamDto;
    private Status.Validation status;
    private String message;

}
