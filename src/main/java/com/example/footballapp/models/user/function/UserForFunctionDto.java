package com.example.footballapp.models.user.function;

import com.example.footballapp.models.user.UserDto;
import com.example.footballapp.models.status.Status;
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
