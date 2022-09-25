package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetPlayerInformation {

    private PlayerDto playerInformation;
    private TeamDto teamInformation;
    private Status.Validation status;
    private String message;

}
