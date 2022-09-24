package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayerOfTeamEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerOfTeamRepository extends CrudRepository<PlayerOfTeamEntity,Long> {

    @Query("SELECT pt FROM PlayerOfTeamEntity as pt" +
            " WHERE pt.playersEntity.idPlayer=:idPlayer" +
            " AND pt.teamsEntity.idTeam=:idTeam")
    PlayerOfTeamEntity findPlayerInTeam(Long idPlayer, Long idTeam);

}
