package com.example.footballapp.mapper;

import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.user.function.AddPlayerDto;
import com.example.footballapp.models.status.Status;
import com.example.footballapp.entity.PlayersEntity;
import com.example.footballapp.repository.PlayersRepository;
import com.example.footballapp.util.CheckingRegularExpresion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayersMapper {

    private final PlayersRepository playersRepository;

    @Autowired
    public PlayersMapper(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
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

            Long idPlayer = this.playersRepository.getIdPlayer(name,surname,dateOfBirth,position);

            return AddPlayerDto
                    .builder()
                    .idPlayer(idPlayer)
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
