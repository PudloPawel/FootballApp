package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.PlayersTeamRepository;
import com.example.footbalapp.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PlayersTeamMapper {

    private PlayersRepository playersRepository;

    @Autowired
    public PlayersTeamMapper(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public List<PlayerDto> getPlayersOfTeam(Long idTeam){

        List<PlayerDto> playerDtoList = new ArrayList<>();

        try{
            List<PlayersEntity> playersEntities = this.playersRepository.getPlayersTeam(idTeam);

            for(PlayersEntity player:playersEntities) {
                playerDtoList.add(new PlayerDto(player.getIdPlayer(),
                        player.getName(),
                        player.getSurname(),
                        player.getDateOfBirth(),
                        player.getPosition(),
                        player.getNumberPlayer()));
            }
            return playerDtoList;
        }catch (Exception var4){
            return playerDtoList;
        }




    }
}
