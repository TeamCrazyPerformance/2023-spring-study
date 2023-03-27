package org.example.dao;

import org.example.domain.Person;

import java.time.LocalDate;

public interface MyDao {
    Person save(Person person);
    Person find(String name);
    Person update(String name, LocalDate birthday, String introduction);
    boolean delete(String name);
}
