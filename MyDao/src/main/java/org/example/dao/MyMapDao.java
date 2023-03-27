package org.example.dao;

import org.example.controller.dto.PersonCreateDto;
import org.example.controller.dto.PersonUpdateDto;
import org.example.domain.Person;

import java.util.HashMap;
import java.util.Map;

public class MyMapDao implements MyDao {

    //key 값은 마음대로 변경 가능
    private final Map<String, Person> peopleData;

    public MyMapDao() {
        this.peopleData = new HashMap<>();
    }

    @Override
    public Person save(PersonCreateDto dto) {
        return null;
    }

    @Override
    public Person find(String name) {
        return null;
    }

    @Override
    public Person update(String name, PersonUpdateDto dto) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
