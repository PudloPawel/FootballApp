package com.example.footballapp.security.config;

import com.example.footballapp.models.user.UserDto;
import com.example.footballapp.entity.UsersEntity;
import com.example.footballapp.mapper.UsersMapper;
import com.example.footballapp.repository.UsersRepository;
import com.example.footballapp.security.permission.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccessConfig {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    private static final String login = "admin";
    private static final String password = "testowy";
    private static final String email = "testowy@gmail.com";

    @EventListener(ApplicationReadyEvent.class)
    public void loadData(){

        Optional<UsersEntity> admin = usersRepository.findByLogin(login);

        if(admin.isPresent()){
            usersMapper.registerUser(UserDto.builder()
                    .login(login)
                    .password(password)
                    .email(email)
                    .typeUser(ApplicationUserRole.ADMIN)
                    .build());
        }


    }

}
