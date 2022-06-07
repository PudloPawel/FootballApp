package com.example.footbalapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {

    private Long idPlayer;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String position;
    private Long number;

    public PlayerDto(Long idPlayer, String name, String surname, String dateOfBirth, String position, Long number) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.number = number;
    }
}
