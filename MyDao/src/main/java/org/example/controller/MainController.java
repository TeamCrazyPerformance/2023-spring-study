package org.example.controller;

import org.example.domain.Person;
import org.example.service.MyDaoService;
import org.example.view.InputView;

public class MainController {

  private MyDaoService myDaoService;
  
  private MyDaoService listService;
  private MyDaoService mapService;

  private InputView inputView;

  public MainController() {
    this.listService = new MyDaoService("LIST");
    this.mapService = new MyDaoService("MAP");
    this.inputView = new InputView();
  }

  public void control() {
    int command = inputView.inputCommand();
    switch(command) {
      case 1: useSavePersonService();break;
      case 2: useFindPersonService();break;
      case 3: useUpdatePersonService();break;
      case 4: useDeletePersonService();break;
    }
  }

  public void setDataBase() {
    String DBName = inputView.inputDBName();
    if(DBName.toUpperCase().equals("LIST")) {
      this.myDaoService = listService;
      return;
    }
    this.myDaoService = mapService;
  }

  /** code that using save person service **/
  public void useSavePersonService() {
    String[] tokens = inputView.inputNewPerson();
    myDaoService.savePerson(new Person(tokens));
  }

  /** code that using find person service **/
  public void useFindPersonService() {
    String name = inputView.inputFind();
    myDaoService.findPerson(name);
  }
  
  /** code that using update prtson service **/
  public void useUpdatePersonService() {
    String name = inputView.inputUpdate();
    String[] tokens = inputView.inputUpdatePerson(name);
    myDaoService.updatePerson(name, tokens);
  }

  /** code that using delete person service **/
  public void useDeletePersonService() {
    String name = inputView.deletePerson();
    myDaoService.deletePerson(name);
  }

}
