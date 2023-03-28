package org.example;
import org.example.dao.MyDao;
import org.example.dao.MyListDao;
import org.example.domain.InputView;
import org.example.domain.OutputView;
import org.example.domain.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MyListDao myListDao = new MyListDao();
        inputView.inputDataType();
        inputView.inputDataBhvr();
        outputView.outputSave(inputView.inputData());

    }
}