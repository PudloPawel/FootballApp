package com.example.footbalapp.repository;


import com.example.footbalapp.entity.PlayersTeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersTeamRepository extends CrudRepository<PlayersTeamEntity,Long> {

}
