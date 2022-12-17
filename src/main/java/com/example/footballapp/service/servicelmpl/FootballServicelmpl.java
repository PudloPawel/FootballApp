package com.example.footballapp.service.servicelmpl;

import com.example.footballapp.models.NewsDto;
import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.PlayerForTeamDto;
import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.functionDto.*;
import com.example.footballapp.mapper.NewsMapper;
import com.example.footballapp.mapper.PlayersMapper;
import com.example.footballapp.mapper.PlayersTeamMapper;
import com.example.footballapp.mapper.TeamsMapper;
import com.example.footballapp.models.user.function.AddPlayerDto;
import com.example.footballapp.models.user.function.GetPlayerInformation;
import com.example.footballapp.service.FootballService;
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
    public NewsModelDto addNews(NewsDto newsDto) {
        return this.newsMapper.addNews(newsDto);
    }

    @Override
    public NewsModelDto editNews(NewsDto newsDto, Long idNews) {
        return this.newsMapper.editNews(newsDto,idNews);
    }

    @Override
    public NewsModelDto deleteNews(Long idNews) {
        return this.newsMapper.deleteNews(idNews);
    }

    @Override
    public NewsModelDto getNews(Long idNews) {
        return this.newsMapper.getNews(idNews);
    }

    @Override
    public GetNewsDto getAllNews() {
        return this.newsMapper.getAllNews();
    }

    @Override
    public GetPlayersOfTeam getPlayersOfTeamByPosition(Long idTeam) {
        return this.playersTeamMapper.getPlayersOfTeamByPosition(idTeam);
    }
}
