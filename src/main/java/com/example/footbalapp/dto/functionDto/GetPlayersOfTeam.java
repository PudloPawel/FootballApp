package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.status.Status;
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
