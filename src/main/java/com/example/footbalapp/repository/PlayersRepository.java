package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PlayersRepository extends CrudRepository<PlayersEntity,Long> {

    @Query("SELECT PE FROM PlayersEntity as PE, PlayersTeamEntity PTE, TeamsEntity as TE WHERE PTE.idPlayer=PE.idPlayer AND PTE.idTeam=:idTeam")
    List<PlayersEntity> getPlayersTeam(@Param("idTeam") Long idTeam);

}
