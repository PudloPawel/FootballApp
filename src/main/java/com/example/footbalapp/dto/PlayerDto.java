package com.example.footbalapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PlayerDto implements Comparable<PlayerDto> {

    private String name;
    private String surname;
    private String dateOfBirth;
    private String position;

    public PlayerDto(String name, String surname, String dateOfBirth, String position) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

    @Override
    public int compareTo(PlayerDto o) {
        return this.position.compareTo(o.position);
    }
}
