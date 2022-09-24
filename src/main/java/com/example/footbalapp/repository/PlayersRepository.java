package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends CrudRepository<PlayersEntity,Long> {

    @Query("SELECT p FROM PlayersEntity AS p" +
            " WHERE p.idPlayer =:idPlayer ")
    PlayersEntity findPlayer(Long idPlayer);
}
