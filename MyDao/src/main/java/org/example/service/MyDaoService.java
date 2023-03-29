package org.example.service;

import org.example.dao.MyDao;
import org.example.dao.MyListDao;
import org.example.dao.MyMapDao;
import org.example.domain.Person;

public class MyDaoService {
  private MyDao myDao;

  public MyDaoService(String DBName) {
    if(DBName.equals("LIST")) this.myDao = new MyListDao();
    if(DBName.equals("MAP")) this.myDao = new MyMapDao();
  }

  public void savePerson(Person person) {
    if(isDuplication(person.getName())) {
      myDao.save(person);
    }
    return;
  }

  public void findPerson(String name) {
    Person person = myDao.find(name);
    if(person != null) {
      System.out.println("데이터 조회 결과입니다.");
      person.printPersonInfo();
      return;
    }
    System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
  }

  public void updatePerson(String name, String[] updateInfo) {
    Person personBefore = myDao.find(name);
    if(personBefore != null) {
      Person personAfter = myDao.update(name, updateInfo);
      System.out.println("데이터 수정 결과 입니다");
      printUpdatedDescription(personBefore, personAfter);
      return;
    }
    System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
  }

  public void deletePerson(String name) {
    myDao.delete(name);
  }

  /** code for check isDuplication **/
  private boolean isDuplication(String name) {
    if(myDao.find(name) != null) {
      System.out.println("[ERROR] 이름은 중복될 수 없습니다.");
      return false;
    }
    return true;
  }

  private void printUpdatedDescription(Person personBefore, Person personAfter) {
    String fisrtLine = String.format("이름: [%s], 나이: [%d] -> [%d], 생일: [%s] -> [%s]", 
      personAfter.getName(), personBefore.getAge(), personAfter.getAge(), personBefore.getBirthDay(), personAfter.getBirthDay());
    String secondLine = String.format("자기소개: [%s] -> [%s]", personBefore.getDescription(), personAfter.getDescription());
    System.out.println(fisrtLine);
    System.out.println(secondLine);
  }
}
