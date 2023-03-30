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
  }

  public void findPerson(String name) {
    Person person = myDao.find(name);
    if(person != null) {
      System.out.println("데이터 조회 결과입니다.");
      printPerson(person);
      return;
    }
    System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
  }

  public void updatePerson(String name, String[] updateInfo) {
    Person personBefore = myDao.find(name);
    if(personBefore != null) {
      personBefore = new Person(personBefore);
      Person personAfter = myDao.update(name, updateInfo);
      System.out.println("데이터 수정 결과 입니다");
      printUpdatedDescription(personBefore, personAfter);
      return;
    }
    System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
  }

  public void deletePerson(String name) {
    int code = myDao.delete(name);
    if(code == 1){
      System.out.println(String.format("%s 님이 삭제 되었습니다.", name));
      return;
    }
    System.out.println("[ERROR] 존재하지 않는 이름입니다.");
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
    String firstLine = String.format("이름: [%s], 나이: [%d] -> [%d], 생일: [%s] -> [%s]",
      personAfter.getName(), personBefore.getAge(), personAfter.getAge(), personBefore.getBirthDay(), personAfter.getBirthDay());
    String secondLine = String.format("자기소개: [%s] -> [%s]", personBefore.getDescription(), personAfter.getDescription());
    System.out.println(firstLine);
    System.out.println(secondLine);
  }
  private void printPerson(Person person) {
    String formatter = String.format("이름: [%s], 나이: [%d], 생일: [%s]\n자기소개: [%s]", 
      person.getName(), person.getAge(), person.getBirthDay(), person.getDescription());
    System.out.println(formatter);
  }
}
