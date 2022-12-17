package com.example.footballapp.models.functionDto;

import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.status.Status;
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
