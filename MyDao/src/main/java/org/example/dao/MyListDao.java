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
        outputView.outputSave(person);
        return person;

    }

    @Override
    public Person find(String name) {
        return peopleList.stream()
                .filter(person -> person.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Person update(String updateName, String updateDataBirth, String updateDataMe) {
        for (Person person : peopleList){
            if (person.getName().equals(updateName)){
                person.setBirth(updateDataBirth);
                person.setMe(updateDataBirth);
                return person;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    @Override
    public void delete(String name) {
        try{
            peopleList.remove(name);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }


}
