package com.example.footballapp.repository;

import com.example.footballapp.entity.TeamsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity,Long> {

    @Query("SELECT t FROM TeamsEntity as t" +
            " WHERE t.idTeam =:idTeam ")
    TeamsEntity findTeam(@Param("idTeam") Long idTeam);

    @Query("SELECT t FROM TeamsEntity as t")
    List<TeamsEntity> findTeams();

    @Query("SELECT t.idTeam FROM TeamsEntity AS t " +
            "WHERE t.nameCategoryPl=:namePl " +
            "AND t.nameCategoryENG=:nameEng ")
    Long getIdTeam(@Param("namePl") String namePl,
                   @Param("nameEng") String nameEng);


}
