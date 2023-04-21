package org.example.dao;

import org.example.domain.Person;

import java.util.Optional;

public interface MyDao {
    Person save(Person person);
    Person find(String name);
    Person update(String updateName, String updateDataBirth, String updateDataMe);
    void delete(String name);
}
