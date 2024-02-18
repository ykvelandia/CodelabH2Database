package com.example.codelabH2.repository;


import com.example.codelabH2.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    User findUserById(Long idUser);
    User createUser(User user);
    Boolean updateUser (Long idUser, User user);
    Boolean deleteUser(Long idUser);
}
