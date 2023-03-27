package org.example.domain;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private int age;
    private LocalDate birthDate;
    private String intro;

    public Person(String name, LocalDate birthDate, String intro) {
        this.name = name;
        this.birthDate = birthDate;
        LocalDate today = LocalDate.now();
        int age = Period.between(birthDate, today).getYears();
        this.age = age;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getIntro() {
        return intro;
    }
    // update 메소드 추가
    public void update(LocalDate birthDate, String intro) {
        this.birthDate = birthDate;
        LocalDate today = LocalDate.now();
        int age = Period.between(birthDate, today).getYears();
        this.age = age;
        this.intro = intro;
    }
}
