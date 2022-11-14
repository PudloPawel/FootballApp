package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.UserDto;
import com.example.footbalapp.dto.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserForFunctionDto {

    private Long idUser;
    private UserDto userDto;
    private Status.Validation status;
    private String message;

}
