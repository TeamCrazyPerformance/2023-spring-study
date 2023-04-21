package org.example;
import org.example.controller.BhvrController;
import org.example.controller.Controller;
import org.example.dao.MyListDao;
import org.example.domain.DataBhvr;
import org.example.domain.InputView;
import org.example.domain.OutputView;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.processRun();
    }
}