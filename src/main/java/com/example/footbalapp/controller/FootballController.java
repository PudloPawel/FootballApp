package com.example.footbalapp.controller;

import com.example.footbalapp.dto.PlayerDto;
import com.example.footbalapp.service.FootballService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/api")
public class FootballController {

    private FootballService footballService;

    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping("/getPlayers/{idTeam}")
    public ResponseEntity<List<PlayerDto>> getPlayersOfTeam(@PathVariable(value = "idTeam") Long idTeam){
        return new ResponseEntity<>(footballService.getPlayersOfTeam(idTeam), HttpStatus.OK);
    }

}
