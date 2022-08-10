package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.TeamsRepository;
import com.example.footbalapp.util.CheckingRegularExpresion;
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

    public List<PlayerDto> getPlayersOfTeam(Long idTeam) {

        List<PlayerDto> playerDtoList = new ArrayList<>();

        try {


            return playerDtoList;
        } catch (Exception var4) {
            return playerDtoList;
        }


    }

    // Function for add data player in DataBase
    public AddPlayerDto addPlayer(PlayerDto playerDto) {
        try {
            String name = playerDto.getName();
            String surname = playerDto.getSurname();
            String dateOfBirth = playerDto.getDateOfBirth();
            String position = playerDto.getPosition();

            CheckingRegularExpresion checkingRegularExpresion = new CheckingRegularExpresion();

            if(checkingRegularExpresion.checkStringForNumbers(name)
                    || checkingRegularExpresion.checkStringForNumbers(surname)
                    || checkingRegularExpresion.checkStringForNumbers(position)){
                return AddPlayerDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("Number found in word")
                        .build();
            }

            if(!checkingRegularExpresion.checkStringDate(dateOfBirth)){
                return AddPlayerDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("Bad key in date: try set type date: 27-04-1992")
                        .build();
            }

            PlayersEntity playerEntity = new PlayersEntity(name,surname,dateOfBirth,position);

            for (PlayersEntity playersEntity : this.playersRepository.findAll()) {
                if (playersEntity.equals(playerEntity)) return AddPlayerDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("This player already exists")
                        .build();
            }

            this.playersRepository.save(playerEntity);

            return AddPlayerDto
                    .builder()
                    .playerDto(playerDto)
                    .status(Status.Validation.SUCCESSFUL)
                    .message("You add player")
                    .build();

        } catch (Exception var4) {
            return AddPlayerDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }

}
