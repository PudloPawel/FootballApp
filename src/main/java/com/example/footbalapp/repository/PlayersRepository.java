package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends CrudRepository<PlayersEntity,Long> {

    @Query("SELECT p FROM PlayersEntity AS p" +
            " WHERE p.idPlayer =:idPlayer ")
    PlayersEntity findPlayer(@Param("idPlayer") Long idPlayer);

    @Query("SELECT p.idPlayer FROM PlayersEntity AS p " +
            "WHERE p.name=:name " +
            "AND p.surname=:surname " +
            "AND p.dateOfBirth=:dateOfBirth " +
            "AND p.position=:position")
    Long getIdPlayer(@Param("name") String name,
                     @Param("surname") String surname,
                     @Param("dateOfBirth") String date,
                     @Param("position") String position);
}
