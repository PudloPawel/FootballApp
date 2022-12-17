package com.example.footballapp.models.user.function;

import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetPlayerInformation {

    private PlayerDto playerInformation;
    private TeamDto teamInformation;
    private Status.Validation status;
    private String message;

}
