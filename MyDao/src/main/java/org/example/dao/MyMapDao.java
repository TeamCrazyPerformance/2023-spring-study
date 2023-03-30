package org.example.dao;

import org.example.domain.Person;

import java.util.HashMap;
import java.util.Map;

public class MyMapDao implements MyDao {

  //key 값은 마음대로 변경 가능
  private final Map<Object, Person> peopleData;

  public MyMapDao() {
    peopleData = new HashMap<Object, Person>();
  }

  public Person save(Person person) {
    peopleData.put(person.getName(), person);
    return person;
  }

  public Person find(String name) {
    return peopleData.get(name);
  }

  public Person update(String name, String[] updateInfo) {
    peopleData.remove(name);
    peopleData.put(name, new Person(new String[] {name, updateInfo[0], updateInfo[1]}));
    return peopleData.get(name);
  }

  public int delete(String name) {
    peopleData.remove(name);
    return 1;
  }

}
