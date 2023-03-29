package org.example.controller;

import org.example.service.MyDaoService;

public class MainController {

  private MyDaoService myDaoService;

  public MainController() {
    String DBName = null;
    this.myDaoService = new MyDaoService(DBName);
  }

  /** code that using save person service **/
  private void useSavePersonService() {
  }

  /** code that using find person service **/
  private void useFindPersonService() {
  }
  
  /** code that using update prtson service **/
  private void useUpdatePersonService() {
  }

  /** code that using delete person service **/
  private void useDeletePersonService() {
  }

}
