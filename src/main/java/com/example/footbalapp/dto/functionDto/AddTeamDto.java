package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddTeamDto {

    private TeamDto teamDto;
    private Status.Validation status;
    private String message;

}
