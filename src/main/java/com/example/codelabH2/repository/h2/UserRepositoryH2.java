package com.example.codelabH2.repository.h2;

import com.example.codelabH2.model.User;
import com.example.codelabH2.repository.UserRepository;
import com.example.codelabH2.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryH2 implements UserRepository {
    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    public List<User> getAllUsers() {
        return userRepositoryJpa.findAll();
    }
    @Override
    public User findUserById(Long idUser) {
        return userRepositoryJpa.findById(idUser).get();
    }
    @Override
    public User createUser(User user) {
        return userRepositoryJpa.save(user);
    }
    @Override
    public Boolean updateUser(Long idUser, User user) {
        User userFound = findUserById(idUser);
        if (userFound != null){
            userFound.updateUser(user);
            userRepositoryJpa.save(userFound);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Boolean deleteUser(Long idUser) {
        User userFound = findUserById(idUser);
        if (userFound != null){
            userRepositoryJpa.delete(userFound);
            return true;
        }else {
            return null;
        }
    }
}
