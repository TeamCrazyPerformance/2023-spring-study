package org.example.dao;

import org.example.domain.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MyMapDao implements MyDao {

    //key 값은 마음대로 변경 가능
    private final Map<String, Person> peopleData = new HashMap<>();


    @Override
    public Person save(Person person) {
        peopleData.put(person.getName(), person);
        return person;
    }

    @Override
    public Person find(String name) {
        for(String key : peopleData.keySet()){
            if(peopleData.get(key).equals(name)){
                return peopleData.get(name);
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    @Override
    public Person update(String updateName, String updateDataBirth, String updateDataMe) {
        if(peopleData.containsKey(updateName)){
            Person person = new Person(updateName, updateDataBirth, updateDataMe);
            peopleData.put(person.getName(),person);
            return person;
        }
        throw new IllegalArgumentException("[ERROR");
    }

    @Override
    public void delete(String name) {
        try{
            peopleData.remove("name");
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
