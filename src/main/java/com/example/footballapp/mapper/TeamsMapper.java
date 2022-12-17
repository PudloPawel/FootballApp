package com.example.footballapp.mapper;

import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.functionDto.AddTeamDto;
import com.example.footballapp.models.functionDto.TeamsDto;
import com.example.footballapp.models.status.Status;
import com.example.footballapp.entity.TeamsEntity;
import com.example.footballapp.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

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
            Long idTeam = this.teamsRepository.getIdTeam(namePl,nameEng);

            return AddTeamDto
                    .builder()
                    .idTeam(idTeam)
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


    public TeamsDto getTeams() {

        try{

            List<TeamsEntity> teamsListEntity = this.teamsRepository.findTeams();
            List<TeamDto> teamsList = new ArrayList();

            for (TeamsEntity teams:teamsListEntity) {
                teamsList.add(TeamDto
                        .builder()
                        .nameTeamPl(teams.getNameCategoryPl())
                        .nameTeamEng(teams.getNameCategoryENG())
                        .build());
            }

            if(teamsListEntity.size() <= 0 || teamsListEntity == null){
                return TeamsDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Not found Teams"))
                        .build();
            }else{
                return TeamsDto
                        .builder()
                        .teams(teamsList)
                        .status(Status.Validation.SUCCESSFUL)
                        .message(String.format("Found Teams"))
                        .build();
            }

        }catch (Exception var4){
            return TeamsDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }
}
