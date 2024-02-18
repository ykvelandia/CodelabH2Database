package com.example.codelabH2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.codelabH2.dto.UserDto;
import com.example.codelabH2.dto.UserResponseDto;
import com.example.codelabH2.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long idUser){
        try {
            return new ResponseEntity<>(userService.findUserById(idUser), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + idUser + " doesn't in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long idUser, @RequestBody UserDto userDto){
        try {
            Boolean isUpdated = userService.updateUser(idUser, userDto);
            if (isUpdated){
                return new ResponseEntity("The user updated ok", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + idUser + " doesn't in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long idUser){
        return new ResponseEntity<>(userService.deleteUser(idUser), HttpStatus.OK);
    }
}

