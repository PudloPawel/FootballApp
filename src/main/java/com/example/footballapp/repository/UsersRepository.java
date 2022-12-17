package com.example.footballapp.repository;

import com.example.footballapp.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity,Long> {

    @Query("SELECT UE FROM UsersEntity AS UE WHERE UE.login=:login AND UE.email=:email")
    UsersEntity getUsersByDataBase(@Param("login") String login, @Param("email") String email);

    @Query("SELECT UE FROM UsersEntity AS UE WHERE UE.login=:login")
    Optional<UsersEntity> findByLogin(@Param("login") String login);

    @Query("SELECT UE FROM UsersEntity AS UE WHERE UE.idUser=:id AND UE.secretKey=:secretKey")
    Optional<UsersEntity> findByIdAndSecretKey(Long id, String secretKey);

}
