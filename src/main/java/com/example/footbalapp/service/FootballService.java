package com.example.footbalapp.service;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;

import java.util.*;

public interface FootballService {

    List<PlayerDto> getPlayersOfTeam(Long idTeam);

    AddPlayerDto addPlayer(PlayerDto playerDto);

}
