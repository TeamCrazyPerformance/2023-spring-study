package org.example.dao;

import org.example.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class MyListDao implements MyDao {

  private final List<Person> peopleList;

  public MyListDao() {
    peopleList = new ArrayList<Person>();
  }

  public Person save(Person person) {
    peopleList.add(person);
    return person;
  }

  public Person find(String name) {
    int idx = findIndex(name);
    if(idx != -1) {
      return peopleList.get(idx);
    }
    return null;
  }

  public Person update(String name, String[] updateInfo) {
    int idx = findIndex(name);
    if(idx != -1) {
      peopleList.get(idx).updateInfo(updateInfo);
      return peopleList.get(idx);
    }
    return null;
  }

  public int delete(String name) {
    int idx = findIndex(name);
    if(idx != -1) {
      peopleList.remove(idx);
      return 1;
    }
    return -1;
  }

  /** code for search peopleList **/
  private int findIndex(String name) {
    for(int i=0; i<peopleList.size(); i++) {
      if(peopleList.get(i).getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

}
