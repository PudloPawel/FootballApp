package com.example.footbalapp.service.servicelmpl;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.*;
import com.example.footbalapp.mapper.NewsMapper;
import com.example.footbalapp.mapper.PlayersMapper;
import com.example.footbalapp.mapper.PlayersTeamMapper;
import com.example.footbalapp.mapper.TeamsMapper;
import com.example.footbalapp.repository.NewsRepository;
import com.example.footbalapp.service.FootballService;
import org.springframework.stereotype.Service;

@Service
public class FootballServicelmpl implements FootballService {

    private PlayersMapper playersMapper;
    private TeamsMapper teamsMapper;
    private PlayersTeamMapper playersTeamMapper;
    private NewsMapper newsMapper;

    public FootballServicelmpl(PlayersMapper playersMapper,
                               TeamsMapper teamsMapper,
                               PlayersTeamMapper playersTeamMapper,
                               NewsMapper newsMapper) {
        this.playersMapper = playersMapper;
        this.teamsMapper = teamsMapper;
        this.playersTeamMapper = playersTeamMapper;
        this.newsMapper = newsMapper;
    }

    @Override
    public GetPlayersOfTeam getPlayersOfTeam(Long idTeam) {
        return this.playersTeamMapper.getPlayersOfTeam(idTeam);
    }

    @Override
    public GetPlayerInformation getPlayerOfTeam(PlayerForTeamDto playerForTeamDto) {
        return this.playersTeamMapper.getInformationPlayerOfTeam(playerForTeamDto);
    }

    @Override
    public AddPlayerDto addPlayer(PlayerDto playerDto) {
        return this.playersMapper.addPlayer(playerDto);
    }

    @Override
    public AddTeamDto addTeam(TeamDto teamDto) {
        return this.teamsMapper.addTeam(teamDto);
    }

    @Override
    public ChangePlayerInTheTeamDto addPlayerForTeam(PlayerForTeamDto playerForTeamDto) {
        return this.playersTeamMapper.addPlayerForTeam(playerForTeamDto);
    }

    @Override
    public TeamsDto getTeams() {
        return this.teamsMapper.getTeams();
    }

    @Override
    public ChangePlayerInTheTeamDto deletePlayerOfTeam(PlayerForTeamDto playerForTeamDto) {
        return this.playersTeamMapper.deletePlayerOfTeam(playerForTeamDto);
    }

    @Override
    public AddNewsDto addNews(NewsDto newsDto) {
        return this.newsMapper.addNews(newsDto);
    }
}
