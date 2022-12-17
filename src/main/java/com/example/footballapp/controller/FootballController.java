package com.example.footballapp.controller;

import com.example.footballapp.models.NewsDto;
import com.example.footballapp.models.PlayerDto;
import com.example.footballapp.models.PlayerForTeamDto;
import com.example.footballapp.models.TeamDto;
import com.example.footballapp.models.functionDto.*;
import com.example.footballapp.models.status.Status;
import com.example.footballapp.models.user.function.AddPlayerDto;
import com.example.footballapp.models.user.function.GetPlayerInformation;
import com.example.footballapp.service.FootballService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class FootballController {

    @Autowired
    private FootballService footballService;

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
    @GetMapping("/getPlayersByPosition/{idTeam}")
    public ResponseEntity<GetPlayersOfTeam> getPlayersOfTeamByPosition(@PathVariable(value = "idTeam") Long idTeam){

        GetPlayersOfTeam getPlayersOfTeamByPosition = footballService.getPlayersOfTeamByPosition(idTeam);

        if(getPlayersOfTeamByPosition.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getPlayersOfTeamByPosition, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getPlayersOfTeamByPosition,HttpStatus.BAD_REQUEST);
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
    @PostMapping("/management/addPlayer")
    public ResponseEntity<AddPlayerDto> addPlayer(@RequestBody PlayerDto playerDto){

            AddPlayerDto addPlayerDto = footballService.addPlayer(playerDto);

            if(addPlayerDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
                return new ResponseEntity<>(addPlayerDto,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(addPlayerDto,HttpStatus.BAD_REQUEST);
            }
    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/management/addTeam")
    public ResponseEntity<AddTeamDto> addTeam(@RequestBody TeamDto teamDto){

        AddTeamDto addTeamDto = footballService.addTeam(teamDto);

        if(addTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addTeamDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/management/addPlayerForTeam")
    public ResponseEntity<ChangePlayerInTheTeamDto> addPlayerForTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        ChangePlayerInTheTeamDto addPlayerForTeamDto = this.footballService.addPlayerForTeam(playerForTeamDto);

        if(addPlayerForTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/management/deletePlayerOfTeam")
    public ResponseEntity<ChangePlayerInTheTeamDto> deletePlayerOfTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        ChangePlayerInTheTeamDto deletePlayerOfTeamDto = this.footballService.deletePlayerOfTeam(playerForTeamDto);

        if(deletePlayerOfTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(deletePlayerOfTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(deletePlayerOfTeamDto,HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PostMapping("/management/addNews")
    public ResponseEntity<NewsModelDto> addNews(@RequestBody NewsDto newsDto){

        NewsModelDto newsModelDto = this.footballService.addNews(newsDto);

        if(newsModelDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(newsModelDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(newsModelDto,HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @PutMapping("/management/editNews/{idNews}")
    public ResponseEntity<NewsModelDto> editNews(@RequestBody NewsDto newsDto, @PathVariable(value = "idNews") Long idNews ){

        NewsModelDto editNewsDto = this.footballService.editNews(newsDto,idNews);

        if(editNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(editNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(editNewsDto,HttpStatus.NO_CONTENT);
        }

    }

    @CrossOrigin("http://localhost:63342")
    @DeleteMapping("/management/deleteNews/{idNews}")
    public ResponseEntity<NewsModelDto> deleteNews(@PathVariable(value = "idNews") Long idNews ){
        NewsModelDto deleteNewsDto = this.footballService.deleteNews(idNews);

        if(deleteNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(deleteNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(deleteNewsDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getOneNews/{idNews}")
    public ResponseEntity<NewsModelDto> getOneNews(@PathVariable(value = "idNews") Long idNews){
        NewsModelDto getNewsDto = this.footballService.getNews(idNews);

        if(getNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getNewsDto,HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getNews")
    public ResponseEntity<GetNewsDto> getAllNews(){
        GetNewsDto getNewsDto = this.footballService.getAllNews();

        if(getNewsDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(getNewsDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(getNewsDto,HttpStatus.BAD_REQUEST);
        }
    }

}
