package com.example.codelabH2.service;

import com.example.codelabH2.dto.UserDto;
import com.example.codelabH2.dto.UserMapper;
import com.example.codelabH2.dto.UserResponseDto;
import com.example.codelabH2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplements implements UserService{
    @Autowired
    public UserRepository userRepository;
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userRepository.getAllUsers().forEach(user -> userResponseDtos.add(UserMapper.userToUserResponseDto(user)));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto findUserById(Long idUser) {
        return UserMapper.userToUserResponseDto(userRepository.findUserById(idUser));
    }

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        return UserMapper.userToUserResponseDto(userRepository.createUser(UserMapper.userDtoToUser(userDto)));
    }

    @Override
    public Boolean updateUser(Long idUser, UserDto userDto) {
        return userRepository.updateUser(idUser,UserMapper.userDtoToUser(userDto));
    }

    @Override
    public Boolean deleteUser(Long idUser) {
        return userRepository.deleteUser(idUser);
    }
}
