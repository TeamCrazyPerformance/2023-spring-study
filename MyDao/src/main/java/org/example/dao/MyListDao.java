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
        for (Person p : peopleList) {
            if (p.getName().equals(person.getName())) {
                return null;
            }
        }
        // 데이터베이스에 저장
        peopleList.add(person);
        return person;
    }

    @Override
    public Person find(String name)  {
        // 이름으로 Person 검색
        for (Person person : peopleList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person update(String name, LocalDate birthday, String introduction) {
        // 이름으로 Person 검색
        for (Person person : peopleList) {
            if (person.getName().equals(name)) {
                // Person 객체의 update 메소드 호출하여 수정
                person.update(birthday, introduction);
                return person;
            }
        }
        // 이름으로 검색된 Person이 없을 경우
        return null;
    }
    @Override
    public boolean delete(String name) {
        for (Person person : peopleList) {
            if (person.getName().equals(name)) {
                // Person 객체의 update 메소드 호출하여 삭제
                peopleList.remove(person);
                return true;
            }
        }
        // 이름으로 검색된 Person이 없을 경우
        return false;
    }
}
