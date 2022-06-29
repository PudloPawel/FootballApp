package com.example.footbalapp;

import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.PlayersRepository;
import com.example.footbalapp.repository.TeamsRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Start {

    private TeamsRepository teamsRepository;
    private PlayersRepository playersRepository;

    public Start(TeamsRepository teamsRepository, PlayersRepository playersRepository) {
        this.teamsRepository = teamsRepository;
        this.playersRepository = playersRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        TeamsEntity seniorzy = new TeamsEntity("Seniorzy","Seniors");
        TeamsEntity juniorzy = new TeamsEntity("Juniorzy","Juniors");
        List<TeamsEntity> teams = Arrays.asList(seniorzy,juniorzy);

        PlayersEntity player1 = new PlayersEntity("Jan","Kowalski","27-04-1992","BR",1L);
        PlayersEntity player2 = new PlayersEntity("Adam","Nowak","14-08-1996","N",17L);
        PlayersEntity player3 = new PlayersEntity("Adam","Ptak","14-08-2007","N",99L);
        List<PlayersEntity> players = Arrays.asList(player1,player2,player3);

        seniorzy.addPlayerForTeam(player1);
        seniorzy.addPlayerForTeam(player2);
        juniorzy.addPlayerForTeam(player3);

        playersRepository.saveAll(players);
        teamsRepository.saveAll(teams);

    }

}
