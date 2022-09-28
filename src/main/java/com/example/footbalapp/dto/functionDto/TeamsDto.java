package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class TeamsDto {

    private List<TeamDto> teams;
    private Status.Validation status;
    private String message;

}
