package org.example.dao;

import org.example.domain.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyMapDao implements MyDao {

    //key 값은 마음대로 변경 가능
    private final Map<Object, Person> peopleData = new HashMap<>();


    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public Person find(String name) {
        return null;
    }

    @Override
    public Person update(String name, String updateName) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
