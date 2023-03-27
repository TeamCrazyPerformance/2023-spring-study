package org.example.controller.dto;

import java.time.LocalDate;

public class PersonCreateDto {
    private final String name;
    private final LocalDate birthDay;
    private final String introduction;

    public PersonCreateDto(String name, LocalDate birthDay, String introduction) {
        this.name = name;
        this.birthDay = birthDay;
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getIntroduction() {
        return introduction;
    }
}
