package com.example.footbalapp.service;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.functionDto.AddTeamDto;

import java.util.*;

public interface FootballService {

    List<PlayerDto> getPlayersOfTeam(Long idTeam);

    AddPlayerDto addPlayer(PlayerDto playerDto);

    AddTeamDto addTeam(TeamDto teamDto);

}
