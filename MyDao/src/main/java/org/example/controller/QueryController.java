package org.example.controller;

import org.example.controller.dto.PersonCreateDto;
import org.example.controller.dto.PersonUpdateDto;
import org.example.dao.MyDao;
import org.example.domain.Person;
import org.example.view.InputView;
import org.example.view.OutputView;

public class QueryController {

    private final InputView inputView;
    private final OutputView outputView;

    public QueryController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void save(MyDao dao) {
        PersonCreateDto createDto = inputView.inputCreateData();
        Person person = dao.save(createDto);

        outputView.printSaveResult(person);
    }

    public void find(MyDao dao) {
        String name = inputView.inputFindName();
        Person person = dao.find(name);

        outputView.printFindResult(person);
    }

    public void update(MyDao dao) {
        String name = inputView.inputFindName();
        Person person = dao.find(name);

        PersonUpdateDto updateDto = inputView.inputUpdateData();
        Person update = dao.update(name, updateDto);

        UpdateResultDto resultDto = new UpdateResultDto(person, update);
        outputView.printUpdateResult(resultDto);
    }

    public void delete(MyDao dao) {
        String name = inputView.inputFindName();
        dao.delete(name);

        outputView.printDeleteResult();
    }
}
