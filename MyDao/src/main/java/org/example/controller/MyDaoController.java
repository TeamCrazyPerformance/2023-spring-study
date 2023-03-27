package org.example.controller;

import org.example.dao.MyDao;
import org.example.domain.Command;
import org.example.domain.Query;
import org.example.domain.Database;
import org.example.support.DaoContainer;
import org.example.view.InputView;
import org.example.view.OutputView;

import static org.example.domain.Command.*;

public class MyDaoController {

    private final DaoContainer container;
    private final InputView inputView;
    private final OutputView outputView;
    private final QueryController queryController;

    public MyDaoController() {
        this.container = new DaoContainer();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.queryController = new QueryController(inputView, outputView);
    }

    public void run() {
        Command command = CONTINUE;
        do {
            command = runMyDaoCycle(command);
        } while (command.equals(CONTINUE));
    }

    private Command runMyDaoCycle(Command command) {
        try {
            Database database = inputView.inputDatabase();
            MyDao dao = container.getDaoFromDatabase(database);

            Query query = inputView.inputQuery();
            executeByQuery(query, dao);

            command = inputView.inputCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return command;
    }

    private void executeByQuery(Query command, MyDao dao) {
        switch (command) {
            case SAVE -> queryController.save(dao);
            case FIND -> queryController.find(dao);
            case UPDATE -> queryController.update(dao);
            case DELETE -> queryController.delete(dao);
        }
    }
}
