package com.example.footbalapp.service;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.functionDto.AddPlayerForTeamDto;
import com.example.footbalapp.dto.functionDto.AddTeamDto;
import com.example.footbalapp.dto.functionDto.GetPlayersOfTeam;

import java.util.*;

public interface FootballService {

    GetPlayersOfTeam getPlayersOfTeam(Long idTeam);

    AddPlayerDto addPlayer(PlayerDto playerDto);

    AddTeamDto addTeam(TeamDto teamDto);

    AddPlayerForTeamDto addPlayerForTeam(PlayerForTeamDto playerForTeamDto);

}
