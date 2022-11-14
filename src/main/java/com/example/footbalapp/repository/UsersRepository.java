package com.example.footbalapp.repository;

import com.example.footbalapp.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity,Long> {

    @Query("SELECT UE FROM UsersEntity AS UE WHERE UE.login=:login AND UE.email=:email")
    UsersEntity getUsersByDataBase(@Param("login") String login, @Param("email") String email);

}
