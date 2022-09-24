package com.example.footbalapp.repository;

import com.example.footbalapp.entity.TeamsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity,Long> {

    @Query("SELECT t FROM TeamsEntity as t" +
            " WHERE t.idTeam =:idTeam ")
    TeamsEntity findTeam(Long idTeam);
}
