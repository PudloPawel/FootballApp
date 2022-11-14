package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.UserDto;
import com.example.footbalapp.dto.enums.UserType;
import com.example.footbalapp.dto.functionDto.UserForFunctionDto;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.UsersEntity;
import com.example.footbalapp.repository.UsersRepository;
import com.example.footbalapp.util.CheckingRegularExpresion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UsersMapper {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersMapper(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /// Powtórzenia hasła zrobic po stronie klienta
    public UserForFunctionDto registerUser(UserDto userDto){
        try{

            String login = userDto.getLogin();
            String password = userDto.getPassword();
            String email = userDto.getEmail();
            String typeUser = userDto.getTypeUser();

            CheckingRegularExpresion checkingRegularExpresion = new CheckingRegularExpresion();

            if(checkingRegularExpresion.checkStringForSign(login)){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Bad character in login: %s",login))
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

            if(typeUser.toUpperCase().equals(UserType.Type.NORMAL.toString())
                    || typeUser.toUpperCase().equals(UserType.Type.ADMIN.toString())){
                return UserForFunctionDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Type user %s not exist",typeUser))
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
                this.usersRepository.save(new UsersEntity(login,password,email,typeUser));
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


}
