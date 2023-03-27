package org.example.domain;

import org.example.controller.dto.PersonUpdateDto;

import java.time.LocalDate;

public class Person {
    private String name;
    private int age;
    private LocalDate birthDay;
    private String introduction;

    public Person(String name, LocalDate birthDay, String introduction) {
        this.name = name;
        this.birthDay = birthDay;
        this.age = calculateAge(birthDay);
        this.introduction = introduction;
    }

    private int calculateAge(LocalDate birthDay) {
        LocalDate now = LocalDate.now();
        validateBirthday(birthDay, now);
        return now.minusYears(birthDay.getYear()).getYear();
    }

    private void validateBirthday(LocalDate birthDay, LocalDate now) {
        if (now.isBefore(birthDay)) {
            throw new IllegalArgumentException();
        }
    }

    private Person(String name, int age, LocalDate birthDay, String introduction) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
        this.introduction = introduction;
    }

    public static Person clone(Person person) {
        return new Person(person.getName(), person.getAge(), person.getBirthDay(), person.getIntroduction());
    }

    public void update(PersonUpdateDto updateDto) {
        this.name = updateDto.getName();
        this.birthDay = updateDto.getBirthDay();
        this.age = calculateAge(updateDto.getBirthDay());
        this.introduction = updateDto.getIntroduction();
    }

    public boolean isNameEqualTo(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getIntroduction() {
        return introduction;
    }
}
