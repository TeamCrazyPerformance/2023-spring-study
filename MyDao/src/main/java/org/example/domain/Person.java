package org.example.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
  private String name;
  private LocalDate birthDay;
  private String description;

  private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.M.d");

  public Person(String[] personInfo) throws DateTimeParseException{
    this.name = personInfo[0];
    this.birthDay = LocalDate.parse(personInfo[1], format);
    this.description = personInfo[2];
  }

  public String getName() {return this.name;}
  public String getBirthDay() {return this.birthDay.format(format).toString();}
  public String getDescription() {return this.description;}

  public void printPersonInfo() {
    int age = getAge();
    System.out.println("이름: ["+name+"], 나이: ["+age+"], 생일: ["+birthDay+"]");
    System.out.println("자기소개: ["+description+"]");
  }

  public void updateInfo(String[] newInfo) {
    this.birthDay = LocalDate.parse(newInfo[0], format);
    this.description = newInfo[1];
  }

  public int getAge() {
    LocalDate now = LocalDate.now();
    int age = now.getYear() - birthDay.getYear() + 1;
    return age;
  }
}
