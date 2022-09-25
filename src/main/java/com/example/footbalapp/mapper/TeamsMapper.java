package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.functionDto.AddTeamDto;
import com.example.footbalapp.dto.functionDto.GetPlayersOfTeam;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.TeamsRepository;
import com.example.footbalapp.util.CheckingRegularExpresion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamsMapper {

    private final TeamsRepository teamsRepository;

    @Autowired
    public TeamsMapper(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    // Function for add data team in DataBase
    public AddTeamDto addTeam(TeamDto teamDto) {
        try {
            String namePl = teamDto.getNameTeamPl();
            String nameEng = teamDto.getNameTeamEng();


            TeamsEntity teamEntity = new TeamsEntity(namePl,nameEng);

            for (TeamsEntity teamsEntity : this.teamsRepository.findAll()) {
                if (teamsEntity.equals(teamEntity)) return AddTeamDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("This team already exists, please change team name")
                        .build();
            }

            this.teamsRepository.save(teamEntity);

            return AddTeamDto
                    .builder()
                    .teamDto(teamDto)
                    .status(Status.Validation.SUCCESSFUL)
                    .message("You add team")
                    .build();

        } catch (Exception var4) {
            return AddTeamDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }


}
