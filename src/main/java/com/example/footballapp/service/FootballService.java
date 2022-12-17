package com.example.footballapp.service;

import com.example.footballapp.models.NewsDto;
import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.PlayerForTeamDto;
import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.functionDto.*;
import com.example.footballapp.models.user.function.AddPlayerDto;
import com.example.footballapp.models.user.function.GetPlayerInformation;

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
