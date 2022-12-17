package com.example.footballapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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