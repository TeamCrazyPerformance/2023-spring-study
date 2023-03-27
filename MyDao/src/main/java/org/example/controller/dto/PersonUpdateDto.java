package org.example.controller.dto;

import java.time.LocalDate;

public class PersonUpdateDto {
    private String name;
    private LocalDate birthDay;
    private String introduction;

    public PersonUpdateDto(String name, LocalDate birthDay, String introduction) {
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
