package org.example;
import org.example.dao.MyListDao;
import org.example.domain.InputView;
import org.example.domain.OutputView;

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