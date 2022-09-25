package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerForTeamDto;
import com.example.footbalapp.dto.functionDto.GetPlayerInformation;
import com.example.footbalapp.dto.functionDto.GetPlayersOfTeam;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.PlayerOfTeamEntity;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.PlayerOfTeamRepository;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public GetPlayersOfTeam getPlayersOfTeam(Long idTeam) {
        try{

            List<PlayerDto> playersOfTeamDto = new ArrayList();

            List<PlayersEntity> playersIdList = playerOfTeamRepository.getAllPlayerOfTeam(idTeam);

            if(playersIdList == null){
                return GetPlayersOfTeam
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Don't find player in Team id: %s or Team does not exist",idTeam))
                        .build();
            }



            for (PlayersEntity player: playersIdList) {
                playersOfTeamDto.add(PlayerDto
                        .builder()
                        .name(player.getName())
                        .surname(player.getSurname())
                        .dateOfBirth(player.getDateOfBirth())
                        .position(player.getPosition())
                .build());
            }

            if(playersOfTeamDto.size() == 0){
                return GetPlayersOfTeam
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Don't find player in Team id: %s",idTeam))
                        .build();
            }else{
                return GetPlayersOfTeam
                        .builder()
                        .playerOfTeamDto(playersOfTeamDto)
                        .status(Status.Validation.SUCCESSFUL)
                        .message(String.format("You get Players of Team id: %s",idTeam))
                        .build();
            }


        }catch (Exception var4){
            return GetPlayersOfTeam
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }
    }

    public GetPlayerInformation getInformationPlayerOfTeam(PlayerForTeamDto playerForTeamDto){
        try{

            PlayerDto playerInformation;
            TeamDto teamInformation;

            Long idPlayer = playerForTeamDto.getIdPlayer();
            Long idTeam = playerForTeamDto.getIdTeam();


            PlayerOfTeamEntity playerOfTeamEntity = playerOfTeamRepository.findPlayerInTeam(idPlayer,idTeam);

            if(playerOfTeamEntity == null){
                return GetPlayerInformation
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Player id: %s or Team id: %s does not exist ",idPlayer,idTeam))
                        .build();
            }else{
                playerInformation = PlayerDto
                        .builder()
                        .name(playerOfTeamEntity.getPlayersEntity().getName())
                        .surname(playerOfTeamEntity.getPlayersEntity().getSurname())
                        .dateOfBirth(playerOfTeamEntity.getPlayersEntity().getDateOfBirth())
                        .position(playerOfTeamEntity.getPlayersEntity().getPosition())
                        .build() ;
                teamInformation = TeamDto
                        .builder()
                        .nameTeamPl(playerOfTeamEntity.getTeamsEntity().getNameCategoryPl())
                        .nameTeamEng(playerOfTeamEntity.getTeamsEntity().getNameCategoryENG())
                        .build();

                return GetPlayerInformation
                        .builder()
                        .playerInformation(playerInformation)
                        .teamInformation(teamInformation)
                        .status(Status.Validation.SUCCESSFUL)
                        .message(String.format("Get information about player id: %s of Team id: %s ",idPlayer,idTeam))
                        .build();
            }


        }catch (Exception var4){
            return GetPlayerInformation
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }
    }

}
