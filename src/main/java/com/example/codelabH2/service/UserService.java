package com.example.codelabH2.service;

import com.example.codelabH2.dto.UserDto;
import com.example.codelabH2.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(Long idUser);
    UserResponseDto createUser(UserDto userDto);
    Boolean updateUser(Long idUser,UserDto userDto);
    Boolean deleteUser(Long idUser);
}
