package com.example.footballapp.models.user.function;

import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddPlayerDto {

    private Long idPlayer;
    private PlayerDto playerDto;
    private Status.Validation status;
    private String message;

}
