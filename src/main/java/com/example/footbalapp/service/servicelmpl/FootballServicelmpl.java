package com.example.footbalapp.service.servicelmpl;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.functionDto.AddTeamDto;
import com.example.footbalapp.mapper.PlayersMapper;
import com.example.footbalapp.mapper.TeamsMapper;
import com.example.footbalapp.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballServicelmpl implements FootballService {

    private PlayersMapper playersMapper;
    private TeamsMapper teamsMapper;

    @Autowired
    public FootballServicelmpl(PlayersMapper playersMapper, TeamsMapper teamsMapper) {
        this.playersMapper = playersMapper;
        this.teamsMapper = teamsMapper;
    }

    @Override
    public List<PlayerDto> getPlayersOfTeam(Long idTeam) {
       // return this.playersTeamMapper.getPlayersOfTeam(idTeam);
        return null;
    }

    @Override
    public AddPlayerDto addPlayer(PlayerDto playerDto) {
        return this.playersMapper.addPlayer(playerDto);
    }

    @Override
    public AddTeamDto addTeam(TeamDto teamDto) {
        return this.teamsMapper.addTeam(teamDto);
    }
}
