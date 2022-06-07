package com.example.footbalapp;

import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.PlayersTeamEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.PlayersTeamRepository;
import com.example.footbalapp.repository.TeamsRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private TeamsRepository teamsRepository;
    private PlayersRepository playersRepository;
    private PlayersTeamRepository playersTeamRepository;

    public Start(TeamsRepository teamsRepository, PlayersRepository playersRepository, PlayersTeamRepository playersTeamRepository) {
        this.teamsRepository = teamsRepository;
        this.playersRepository = playersRepository;
        this.playersTeamRepository = playersTeamRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        teamsRepository.save(new TeamsEntity("Seniorzy","Seniors"));
        playersRepository.save(new PlayersEntity("Jan","Kowalski","27-04-1992","BR",1L));
        playersRepository.save(new PlayersEntity("Adam","Nowak","14-08-2000","N",17L));
        playersTeamRepository.save(new PlayersTeamEntity(1L,1L));
        playersTeamRepository.save(new PlayersTeamEntity(2L,1L));
    }

}
