package com.example.footballapp.repository;

import com.example.footballapp.entity.PlayerOfTeamEntity;
import com.example.footballapp.entity.PlayersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerOfTeamRepository extends CrudRepository<PlayerOfTeamEntity,Long> {

    @Query("SELECT pt FROM PlayerOfTeamEntity as pt" +
            " WHERE pt.playersEntity.idPlayer=:idPlayer" +
            " AND pt.teamsEntity.idTeam=:idTeam")
    PlayerOfTeamEntity findPlayerInTeam(@Param("idPlayer") Long idPlayer, @Param("idTeam") Long idTeam);

    @Query("SELECT pt.playersEntity FROM PlayerOfTeamEntity as pt" +
            " WHERE pt.teamsEntity.idTeam=:idTeam")
    List<PlayersEntity> getAllPlayerOfTeam(@Param("idTeam") Long idTeam);

}
