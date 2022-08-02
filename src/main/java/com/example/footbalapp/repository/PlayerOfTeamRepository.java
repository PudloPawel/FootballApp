package com.example.footbalapp.repository;

import com.example.footbalapp.entity.PlayerOfTeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerOfTeamRepository extends CrudRepository<PlayerOfTeamEntity,Long> {
}
