package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerForTeamDto;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.PlayerOfTeamEntity;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.PlayerOfTeamRepository;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayersTeamMapper {

    private final PlayersRepository playersRepository;
    private final TeamsRepository teamsRepository;
    private final PlayerOfTeamRepository playerOfTeamRepository;

    @Autowired
    public PlayersTeamMapper(PlayersRepository playersRepository,
                             TeamsRepository teamsRepository,
                             PlayerOfTeamRepository playerOfTeamRepository) {
        this.playersRepository = playersRepository;
        this.teamsRepository = teamsRepository;
        this.playerOfTeamRepository = playerOfTeamRepository;
    }


    public AddPlayerForTeamDto addPlayerForTeam(PlayerForTeamDto playerForTeamDto){

        Long idPlayer = playerForTeamDto.getIdPlayer();
        Long idTeam = playerForTeamDto.getIdTeam();

        try{

            PlayersEntity playersEntity = this.playersRepository.findPlayer(idPlayer);
            TeamsEntity teamEntity = this.teamsRepository.findTeam(idTeam);


            if(playersEntity == null && teamEntity == null){
                return AddPlayerForTeamDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Not found player with id: %s and Not found team with id: %s",idPlayer,idTeam))
                        .build();
            }else if(playersEntity == null){
                return AddPlayerForTeamDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Not found team with id: %s",idTeam))
                        .build();
            }else if(teamEntity == null){
                return AddPlayerForTeamDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Not found player with id: %s",idPlayer))
                        .build();
            }
            PlayerOfTeamEntity playerOfTeamEntity = new PlayerOfTeamEntity();

            try{
                PlayerOfTeamEntity checkNullEntity = playerOfTeamRepository.findPlayerInTeam(idPlayer,idTeam);
                checkNullEntity.equals(checkNullEntity);
                return AddPlayerForTeamDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Player id: %s is exist in team id: %s",idPlayer,idTeam))
                        .build();
            }catch (Exception ignored){}

            playerOfTeamEntity.setPlayer(playersEntity);
            playerOfTeamEntity.setTeam(teamEntity);
            this.playerOfTeamRepository.save(playerOfTeamEntity);
            return AddPlayerForTeamDto
                    .builder()
                    .playerForTeamDto(playerForTeamDto)
                    .status(Status.Validation.SUCCESSFUL)
                    .message(String.format("You add Player %s id: %s for Team: %s id: %s"
                            ,playersEntity.getName()
                            ,playersEntity.getIdPlayer().toString()
                            ,teamEntity.getNameCategoryENG()
                            ,teamEntity.getIdTeam().toString()))
                    .build();

        }catch (Exception var4){
            return AddPlayerForTeamDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }
    }

}
