package org.example.view;

import org.example.domain.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputView {

    public static int inputInteger(BufferedReader reader) throws IOException {
        int dataCount = Integer.parseInt(reader.readLine());
        if (dataCount != 0 && dataCount != 1)
            throw new IllegalArgumentException("[ERROR] 0 또는 1만 입력 가능합니다");
        return dataCount;
    }

    public static Person inputPerson(BufferedReader reader) throws IOException {
        String[] personData = reader.readLine().split(",");
        String name = personData[0];
        LocalDate birthday = LocalDate.parse(personData[1], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String introduction = personData[2];
        Person person = new Person(name, birthday, introduction);
        return person;
    }
    public static Person inputPerson(BufferedReader reader, String name) throws IOException {
        String[] personData = reader.readLine().split(",");
        LocalDate birthday = LocalDate.parse(personData[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String introduction = personData[1];
        Person person = new Person(name, birthday, introduction);
        return person;
    }

    public static String inputName(BufferedReader reader) throws IOException{
        String name = reader.readLine();
        return name;
    }
}