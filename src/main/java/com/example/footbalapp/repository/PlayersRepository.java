package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends CrudRepository<PlayersEntity,Long> {

}
