package org.example.domain;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Stack;

public class Person {
    private String name;
    private String birth;
    private String me;
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
<<<<<<< HEAD
        Integer[] Age = stringToInt(birth.split(","));
=======
        Integer[] Age = StringToInt(birth.split("\\."));
>>>>>>> 8ede79768f450ca32b711f2d28e7b3d834b1c7b4
        LocalDate localDate = LocalDate.of(Age[0], Age[1], Age[2]);
        LocalDate localDate1 = LocalDate.now().minusYears(localDate.getYear());
        return Integer.toString(localDate1.getYear());
    }

}
