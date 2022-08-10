package com.example.footbalapp.controller;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.dto.functionDto.AddPlayerDto;
import com.example.footbalapp.service.FootballService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api")
public class FootballController {

    private FootballService footballService;

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
    @GetMapping("/addPlayer")
    public ResponseEntity<AddPlayerDto> addPlayer(@RequestBody PlayerDto playerDto){
            // DOdaj zmiane statusu
        return new ResponseEntity<>(footballService.addPlayer(playerDto),HttpStatus.OK);
    }


}
