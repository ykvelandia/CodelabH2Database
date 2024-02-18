package com.example.codelabH2.dto;

import java.time.LocalDate;

public class UserResponseDto {
    private Long idUser;
    private String name;
    private String lastName;
    private LocalDate birthDate;

    public UserResponseDto(Long idUser, String name, String lastName, LocalDate birthDate) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
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
}
