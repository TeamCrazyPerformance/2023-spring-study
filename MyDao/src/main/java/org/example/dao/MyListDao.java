package org.example.dao;
import org.example.domain.InputView;
import org.example.domain.OutputView;
import org.example.domain.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyListDao implements MyDao {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private final List<Person> peopleList;
    public MyListDao() {
        this.peopleList = new ArrayList<>();
    }

    @Override
    public Person save(Person dao) {
        Person person = new Person(dao.getName(), dao.getBirth(),dao.getMe());
        peopleList.add(person);
        return null;
    }

    @Override
    public Person find(String name) {
        return peopleList.stream()
                .filter(person -> person.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Person update(String name, String updateName) {
        return null;
    }

    @Override
    public void delete(String name) {
        peopleList.remove(name);
    }


}
