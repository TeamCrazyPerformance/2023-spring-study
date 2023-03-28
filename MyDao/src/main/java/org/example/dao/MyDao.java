package org.example.dao;

import org.example.domain.Person;

import java.time.LocalDate;

public interface MyDao {
    Person save(Person person);
    Person find(String name);
    Person update(Person p1, Person p2);
    void delete(String name);
}
