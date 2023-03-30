package org.example;

import org.example.controller.MainController;
import org.example.view.InputView;

class App {
  public static void run() {
    InputView inputView = new InputView();
    MainController mainController = new MainController();
    int isContinue;
    while(true) {
      mainController.setDataBase();
      mainController.control();
      isContinue = inputView.isContinue();
      if(isContinue==1) break;
    }
  }
}
