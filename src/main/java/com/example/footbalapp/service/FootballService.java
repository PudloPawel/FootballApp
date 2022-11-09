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

    NewsModelDto addNews(NewsDto newsDto);

    NewsModelDto editNews(NewsDto newsDto, Long idNews);

    NewsModelDto deleteNews(Long idNews);

    NewsModelDto getNews(Long idNews);

    GetNewsDto getAllNews();

    GetPlayersOfTeam getPlayersOfTeamByPosition(Long idTeam);
}
