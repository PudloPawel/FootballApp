package com.example.footbalapp.service;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.*;

import java.util.*;

public interface FootballService {

    GetPlayersOfTeam getPlayersOfTeam(Long idTeam);

    GetPlayerInformation getPlayerOfTeam(PlayerForTeamDto playerForTeamDto);

    AddPlayerDto addPlayer(PlayerDto playerDto);

    AddTeamDto addTeam(TeamDto teamDto);

    AddPlayerForTeamDto addPlayerForTeam(PlayerForTeamDto playerForTeamDto);

    TeamsDto getTeams();

}
