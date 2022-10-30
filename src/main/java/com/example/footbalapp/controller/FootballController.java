package com.example.footbalapp.controller;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.*;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class FootballController {

    private FootballService footballService;

    @Autowired
    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getPlayers/{idTeam}")
    public ResponseEntity<GetPlayersOfTeam> getPlayersOfTeam(@PathVariable(value = "idTeam") Long idTeam){

        GetPlayersOfTeam getPlayersOfTeam = footballService.getPlayersOfTeam(idTeam);

        if(getPlayersOfTeam.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getPlayersOfTeam, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getPlayersOfTeam,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getPlayer")
    public ResponseEntity<GetPlayerInformation> getPlayerOfTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        GetPlayerInformation getPlayerOfTeam = footballService.getPlayerOfTeam(playerForTeamDto);

        if(getPlayerOfTeam.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getPlayerOfTeam, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getPlayerOfTeam,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getTeams")
    public ResponseEntity<TeamsDto> getTeams(){

        TeamsDto getTeams = footballService.getTeams();

        if(getTeams.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getTeams,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getTeams,HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/addPlayer")
    public ResponseEntity<AddPlayerDto> addPlayer(@RequestBody PlayerDto playerDto){

            AddPlayerDto addPlayerDto = footballService.addPlayer(playerDto);

            if(addPlayerDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
                return new ResponseEntity<>(addPlayerDto,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(addPlayerDto,HttpStatus.BAD_REQUEST);
            }
    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/addTeam")
    public ResponseEntity<AddTeamDto> addTeam(@RequestBody TeamDto teamDto){

        AddTeamDto addTeamDto = footballService.addTeam(teamDto);

        if(addTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addTeamDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/addPlayerForTeam")
    public ResponseEntity<ChangePlayerInTheTeamDto> addPlayerForTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        ChangePlayerInTheTeamDto addPlayerForTeamDto = this.footballService.addPlayerForTeam(playerForTeamDto);

        if(addPlayerForTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/deletePlayerOfTeam")
    public ResponseEntity<ChangePlayerInTheTeamDto> deletePlayerOfTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        ChangePlayerInTheTeamDto deletePlayerOfTeamDto = this.footballService.deletePlayerOfTeam(playerForTeamDto);

        if(deletePlayerOfTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(deletePlayerOfTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(deletePlayerOfTeamDto,HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/addNews")
    public ResponseEntity<AddNewsDto> addNews(@RequestBody NewsDto newsDto){

        AddNewsDto addNewsDto = this.footballService.addNews(newsDto);

        if(addNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addNewsDto,HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PutMapping("/editNews/{idNews}")
    public ResponseEntity<AddNewsDto> editNews(@RequestBody NewsDto newsDto, @PathVariable(value = "idNews") Long idNews ){

        AddNewsDto editNewsDto = this.footballService.editNews(newsDto,idNews);

        if(editNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(editNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(editNewsDto,HttpStatus.NO_CONTENT);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/deleteNews/{idNews}")
    public ResponseEntity<AddNewsDto> deleteNews(@PathVariable(value = "idNews") Long idNews ){
        AddNewsDto deleteNewsDto = this.footballService.deleteNews(idNews);

        if(deleteNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(deleteNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(deleteNewsDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getNews/{idNews}")
    public ResponseEntity<AddNewsDto> getNews(@PathVariable(value = "idNews") Long idNews){
        AddNewsDto getNewsDto = this.footballService.getNews(idNews);

        if(getNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getNewsDto,HttpStatus.BAD_REQUEST);
        }
    }

}
