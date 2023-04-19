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
    public Person update(String updateName,String[] updateDataArray) {
        for (Person person : peopleList){
            if (person.getName().equals(updateName)){
                outputView.outputUpdate(person, updateDataArray[0], updateDataArray[1]);
                person.setBirth(updateDataArray[0]);
                person.setMe(updateDataArray[1]);
            }
        }
        return null;
    }

    @Override
    public void delete(String name) {
        peopleList.remove(name);
    }


}
