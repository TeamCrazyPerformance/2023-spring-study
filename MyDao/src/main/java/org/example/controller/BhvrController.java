package org.example.controller;
import org.example.dao.MyDao;
import org.example.dao.MyListDao;
import org.example.domain.DataBhvr;
import org.example.domain.InputView;

public class BhvrController {
    public void bhvrController(DataBhvr bhvr){
        InputView inputView = new InputView();
        MyListDao myListDao = new MyListDao();
        switch(bhvr){
            case save: myListDao.save(inputView.inputData());
            case find: myListDao.find(inputView.inputFindName());
            case update: myListDao.update(inputView.inputUpdateName(), "1999,11,22", "asd");
            case delete: myListDao.delete(inputView.inputDeleteName());
        }
    }

}