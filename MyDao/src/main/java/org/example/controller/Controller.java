package org.example.controller;

import org.example.dao.MyListDao;
import org.example.domain.DataBhvr;
import org.example.domain.InputView;

public class Controller {
    public void processRun() {
        InputView inputView = new InputView();
        inputView.inputDataType();
        while (true) {
            inputView.inputDataBhvr();
            if (inputView.inputDecision() == 1) {
                break;
            }
        }
    }
}
