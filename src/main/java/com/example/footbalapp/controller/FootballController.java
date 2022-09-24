package com.example.footbalapp.controller;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.PlayerForTeamDto;
import com.example.footbalapp.dto.TeamDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.dto.functionDto.AddPlayerForTeamDto;
import com.example.footbalapp.dto.functionDto.AddTeamDto;
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
    /*
    @CrossOrigin("http://localhost:63342")
    @GetMapping("/getPlayers/{idTeam}")
    public ResponseEntity<List<PlayerDto>> getPlayersOfTeam(@PathVariable(value = "idTeam") Long idTeam){
        return new ResponseEntity<>(footballService.getPlayersOfTeam(idTeam), HttpStatus.OK);
    }

     */

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
    public ResponseEntity<AddPlayerForTeamDto> addPlayerForTeam(@RequestBody PlayerForTeamDto playerForTeamDto){

        AddPlayerForTeamDto addPlayerForTeamDto = this.footballService.addPlayerForTeam(playerForTeamDto);

        if(addPlayerForTeamDto.getStatus().equals(Status.Validation.SUCCESSFUL)){
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(addPlayerForTeamDto,HttpStatus.BAD_REQUEST);
        }

    }



}
