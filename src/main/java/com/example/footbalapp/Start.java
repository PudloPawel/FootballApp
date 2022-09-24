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

        PlayersEntity player1 = new PlayersEntity("Jan","Kowalski","27-04-1992","BR");

        List<TeamsEntity> teams = new ArrayList<>();
        List<PlayersEntity> players = new ArrayList<>();


        player1.setTeams(teams);
        seniorzy.setPlayers(players);

        this.playersRepository.save(player1);
        this.teamsRepository.save(seniorzy);

        PlayerOfTeamEntity playerOne = new PlayerOfTeamEntity();

        playerOne.setPlayer(player1);
        playerOne.setTeam(seniorzy);






    }

}
