package com.example.codelabH2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private LocalDateTime create;
    private LocalDateTime update;

    public User() {
    }

    public User(String name, String lastName, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.create = LocalDateTime.now();
        this.update = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public LocalDateTime getUpdate() {
        return update;
    }
    public void updateUser (User user){
        setName(user.getName());
        setLastName(user.getLastName());
        setBirthDate(user.getBirthDate());
        this.update = LocalDateTime.now();
    }

}
