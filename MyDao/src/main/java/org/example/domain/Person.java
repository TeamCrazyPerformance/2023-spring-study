package org.example.domain;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Stack;

public class Person {
    private String name;
    private String birth;
    private String me;
    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setMe(String me) {
        this.me = me;
    }
    public Person(String name, String birth, String me){
        this.name = name;
        this.birth = birth;
        this.me = me;
    }
    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getMe() {
        return me;
    }

    private Integer[] stringToInt(String[] array){
        Integer[] intArray = Arrays.stream(array)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return intArray;
    }
    public String getAge(){
        Integer[] Age = stringToInt(birth.split("\\."));
        LocalDate localDate = LocalDate.of(Age[0], Age[1], Age[2]);
        LocalDate birthData = LocalDate.now().minusYears(localDate.getYear());
        return Integer.toString(birthData.getYear());
    }

}
