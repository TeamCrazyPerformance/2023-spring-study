package org.example.dao;

import org.example.domain.Person;

import java.time.LocalDate;
import java.util.List;

public class MyListDao implements MyDao {
    private final List<Person> peopleList;

    public MyListDao(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public Person save(Person person) {
        // Check if the person already exists in the list
        for (Person p : peopleList) {
            if (p.getName().equals(person.getName())) {
                throw new IllegalArgumentException("해당 이름이 이미 존재합니다.");
            }
        }
        // Add the person to the list
        peopleList.add(person);
        // Return the saved person object
        return person;
    }

    @Override
    public Person find(String name) {
        // 이름으로 Person 검색
        for (Person person : peopleList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당 이름이 존재하지 않습니다.");
    }

    @Override
    public Person update(Person updatePerson, Person updatedPerson) {
        updatePerson.update(updatedPerson.getBirthDate(), updatedPerson.getIntro());
        return updatedPerson;
    }
    @Override
    public void delete(String name) {
        Person person = find(name);
        if(person != null)
        {
            peopleList.remove(person);
            return;
        }
        throw new IllegalArgumentException("[ERROR] 해당 이름이 존재하지 않습니다.");
    }
}
