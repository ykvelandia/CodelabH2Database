package com.example.codelabH2.dto;

import com.example.codelabH2.model.User;

public class UserMapper {

    public static UserResponseDto userToUserResponseDto (User user){
        return new UserResponseDto(
                user.getIdUser(),
                user.getName(),
                user.getLastName(),
                user.getBirthDate()
        );

    }
    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getBirthDate()
        );
    }
}
