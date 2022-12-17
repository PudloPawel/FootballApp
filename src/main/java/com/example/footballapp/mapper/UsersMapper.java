package com.example.footballapp.mapper;

import com.example.footballapp.models.user.UserDto;
import com.example.footballapp.models.enums.UserType;
import com.example.footballapp.models.user.function.UserForFunctionDto;
import com.example.footballapp.models.status.Status;
import com.example.footballapp.entity.UsersEntity;
import com.example.footballapp.repository.UsersRepository;
import com.example.footballapp.security.permission.ApplicationUserRole;
import com.example.footballapp.util.CheckingRegularExpresion;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersMapper {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    /// Powtórzenia hasła zrobic po stronie klienta
    public UserForFunctionDto registerUser(UserDto userDto){
        try{

            String login = userDto.getLogin();
            String password = userDto.getPassword();
            String email = userDto.getEmail();
            ApplicationUserRole typeUser = userDto.getTypeUser();

            CheckingRegularExpresion checkingRegularExpresion = new CheckingRegularExpresion();

            if(checkingRegularExpresion.checkStringForSign(login)){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Bad character in login: %s",login))
                        .build();
            }

            if(checkingRegularExpresion.checkStringForNumbers(String.valueOf(login.charAt(0)))){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("The name cannot start with a number"))
                        .build();
            }

            if(checkingRegularExpresion.checkSpacesInString(password)
                    || checkingRegularExpresion.checkSpacesInString(password)
                    || checkingRegularExpresion.checkSpacesInString(email)){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("No spaces allowed"))
                        .build();
            }

            if(typeUser.equals(UserType.Type.NORMAL.toString())
                    || typeUser.equals(UserType.Type.ADMIN.toString())){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Type user %s not exist",typeUser))
                        .build();
            }

            if(password.length() < 8){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("The password should have at least 8 characters"))
                        .build();
            }

            if(!checkingRegularExpresion.checkCorrectEmail(email)){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Bad email format: %s",email))
                        .build();
            }

            UsersEntity usersEntityForCheckInDataBase = this.usersRepository.getUsersByDataBase(login,email);

            if(usersEntityForCheckInDataBase == null){

                String token = RandomStringUtils.randomAlphanumeric(32);


                this.usersRepository.save(UsersEntity.builder()
                        .login(login)
                        .password(passwordEncoder.encode(password))
                        .email(email)
                        .typeUser(ApplicationUserRole.valueOf(String.valueOf(typeUser)))
                        .secretKey(token)
                        .build());
                usersEntityForCheckInDataBase = this.usersRepository.getUsersByDataBase(login,email);
                if(usersEntityForCheckInDataBase == null){
                    return UserForFunctionDto
                            .builder()
                            .status(Status.Validation.FAILED)
                            .message(String.format("Failed register user: %s",login))
                            .build();
                }else{
                    return UserForFunctionDto
                            .builder()
                            .idUser(usersEntityForCheckInDataBase.getIdUser())
                            .userDto(UserDto.builder()
                                    .login(login)
                                    .password(password)
                                    .email(email)
                                    .typeUser(typeUser)
                                    .build())
                            .status(Status.Validation.SUCCESSFUL)
                            .message(String.format("You register user: %s with role: %s",login,typeUser))
                            .build();
                }
            }else{
                if(usersEntityForCheckInDataBase.getEmail().equals(email)){
                    UserForFunctionDto
                            .builder()
                            .status(Status.Validation.FAILED)
                            .message(String.format("User with login: %s",login))
                            .build();
                }else if(usersEntityForCheckInDataBase.getLogin().equals(login)){
                    UserForFunctionDto
                            .builder()
                            .status(Status.Validation.FAILED)
                            .message(String.format("User with email: %s is exist",email))
                            .build();
                }else{
                    UserForFunctionDto
                            .builder()
                            .status(Status.Validation.FAILED)
                            .message(String.format("User with login: %s and email: %s is exist",login,email))
                            .build();
                }
            }

        }catch (Exception var4){
            return UserForFunctionDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(String.format("Failed register user: %s",var4.getMessage()))
                    .build();
        }

        return UserForFunctionDto
                .builder()
                .status(Status.Validation.FAILED)
                .message(String.format("Failed register user"))
                .build();
    }


    public List<UsersEntity> getUsers(){
        List<UsersEntity> usersEntityList = new ArrayList<>();
        try{
            Iterable<UsersEntity> usersList = this.usersRepository.findAll();
            for(UsersEntity user: usersList){
                usersEntityList.add(user);
            }
            return usersEntityList;
        }catch (Exception var4){
            return usersEntityList;
        }
    }


}
