package org.example.dao;

import org.example.domain.Person;

public interface MyDao {
    Person save(Person person);
    Person find(String name);
    Person update(String name, String[] updateInfo);
    int delete(String name);
}
