package com.example.footbalapp.service;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.*;

public interface FootballService {

    GetPlayersOfTeam getPlayersOfTeam(Long idTeam);

    GetPlayerInformation getPlayerOfTeam(PlayerForTeamDto playerForTeamDto);

    AddPlayerDto addPlayer(PlayerDto playerDto);

    AddTeamDto addTeam(TeamDto teamDto);

    ChangePlayerInTheTeamDto addPlayerForTeam(PlayerForTeamDto playerForTeamDto);

    TeamsDto getTeams();

    ChangePlayerInTheTeamDto deletePlayerOfTeam(PlayerForTeamDto playerForTeamDto);

    AddNewsDto addNews(NewsDto newsDto);
}
