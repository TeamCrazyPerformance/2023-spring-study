package org.example.dao;

import org.example.controller.dto.PersonCreateDto;
import org.example.controller.dto.PersonUpdateDto;
import org.example.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class MyListDao implements MyDao {

    private final List<Person> peopleList;

    public MyListDao() {
        this.peopleList = new ArrayList<>();
    }

    @Override
    public Person save(PersonCreateDto dto) {
        validateExistPerson(dto.getName());
        Person person = new Person(dto.getName(), dto.getBirthDay(), dto.getIntroduction());
        peopleList.add(person);
        return Person.clone(person);
    }

    private void validateExistPerson(String name) {
        boolean isPresentName = peopleList.stream()
                .anyMatch(personData -> personData.isNameEqualTo(name));
        if (isPresentName) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Person find(String name) {
        return Person.clone(findByName(name));
    }

    @Override
    public Person update(String name, PersonUpdateDto dto) {
        Person person = findByName(name);
        person.update(dto);
        return Person.clone(person);
    }

    @Override
    public void delete(String name) {
        Person person = findByName(name);
        peopleList.remove(person);
    }

    private Person findByName(String name) {
        return peopleList.stream()
                .filter(person -> person.isNameEqualTo(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
