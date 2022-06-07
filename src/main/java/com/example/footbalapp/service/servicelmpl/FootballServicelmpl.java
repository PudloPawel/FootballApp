package com.example.footbalapp.service.servicelmpl;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.mapper.PlayersTeamMapper;
import com.example.footbalapp.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballServicelmpl implements FootballService {

    @Autowired
    private PlayersTeamMapper playersTeamMapper;

    @Override
    public List<PlayerDto> getPlayersOfTeam(Long idTeam) {
        return this.playersTeamMapper.getPlayersOfTeam(idTeam);
    }
}
