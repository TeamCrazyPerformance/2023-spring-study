package org.example.dao;

import org.example.domain.Person;

import java.time.LocalDate;
import java.util.Map;

public class MyMapDao implements MyDao {

    //key 값은 마음대로 변경 가능
    private final Map<Object, Person> peopleData;

    public MyMapDao(Map<Object, Person> peopleData) {
        this.peopleData = peopleData;
    }

    @Override
    public Person save(Person person)  {
        // 이름이 없다면 save
        if (!peopleData.containsKey(person.getName()))
        {
            peopleData.put(person.getName(), person);
            return person;
        }
        return null;
    }

    @Override
    public Person find(String name)  {
        if (peopleData.containsKey(name))
            return peopleData.get(name);
        return null;
    }

    @Override
    public Person update(String name, LocalDate birthday, String introduction) {
        // 이름으로 Person 검색
        if (peopleData.containsKey(name)) {
            Person person = peopleData.get(name);
            person.update(birthday, introduction);
            return person;
        }
        // 이름으로 검색된 Person이 없을 경우
        return null;
    }
    @Override
    public boolean delete(String name) {
        Person removedPerson = peopleData.remove(name);
        return removedPerson != null;
    }
}
