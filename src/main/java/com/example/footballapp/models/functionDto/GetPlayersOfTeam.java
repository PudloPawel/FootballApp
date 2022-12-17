package com.example.footballapp.models.functionDto;

import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Builder
@Getter
@Setter
public class GetPlayersOfTeam {

    private List<PlayerDto> playerOfTeamDto;
    private Status.Validation status;
    private String message;

}
