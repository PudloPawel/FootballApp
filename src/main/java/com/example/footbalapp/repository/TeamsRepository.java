package com.example.footbalapp.repository;

import com.example.footbalapp.entity.TeamsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity,Long> {
}
