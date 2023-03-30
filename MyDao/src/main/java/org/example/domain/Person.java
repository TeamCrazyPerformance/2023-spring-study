package org.example.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person implements Cloneable {
  private String name;
  private LocalDate birthDay;
  private String description;

  private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.M.d");

  public Person(String[] personInfo) {
    this.name = personInfo[0];
    this.birthDay = LocalDate.parse(personInfo[1], format);
    this.description = personInfo[2];
  }

  public Person(Person person) {
    this.name = person.name;
    this.birthDay = person.birthDay;
    this.description = person.description;
  }

  public String getName() {return this.name;}
  public String getBirthDay() {return this.birthDay.format(format).toString();}
  public String getDescription() {return this.description;}

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
