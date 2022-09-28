package com.example.footbalapp;

import com.example.footbalapp.entity.PlayerOfTeamEntity;
import com.example.footbalapp.entity.PlayersEntity;
import com.example.footbalapp.entity.TeamsEntity;
import com.example.footbalapp.repository.PlayerOfTeamRepository;
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
    private PlayerOfTeamRepository playerOfTeamRepository;

    public Start(TeamsRepository teamsRepository, PlayersRepository playersRepository, PlayerOfTeamRepository playerOfTeamRepository) {
        this.teamsRepository = teamsRepository;
        this.playersRepository = playersRepository;
        this.playerOfTeamRepository = playerOfTeamRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        TeamsEntity seniorzy = new TeamsEntity("Seniorzy","Seniors");
        TeamsEntity juniorzy = new TeamsEntity("Juniorzy","Juniors");

        PlayersEntity player1 = new PlayersEntity("Jan","Kowalski","27-04-1992","BR");
        PlayersEntity player2 = new PlayersEntity("Adam","Kropka","11-07-1999","N");

        List<TeamsEntity> teams = new ArrayList<>();
        List<PlayersEntity> players = new ArrayList<>();


        player1.setTeams(teams);
        player2.setTeams(teams);
        seniorzy.setPlayers(players);

        this.playersRepository.save(player1);
        this.playersRepository.save(player2);
        this.teamsRepository.save(seniorzy);
        this.teamsRepository.save(juniorzy);

        PlayerOfTeamEntity playerOne = new PlayerOfTeamEntity();
        PlayerOfTeamEntity playerTwo = new PlayerOfTeamEntity();

        playerOne.setPlayer(player1);
        playerTwo.setPlayer(player2);
        playerOne.setTeam(seniorzy);
        playerTwo.setTeam(seniorzy);






    }

}
