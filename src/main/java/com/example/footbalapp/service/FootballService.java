package com.example.footbalapp.service;

import com.example.footbalapp.dto.PlayerDto;
import java.util.*;

public interface FootballService {

    List<PlayerDto> getPlayersOfTeam(Long idTeam);

}
