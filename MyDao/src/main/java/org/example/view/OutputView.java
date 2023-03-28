package org.example.view;

import org.example.domain.Person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class OutputView {

    public static void outputView(BufferedWriter writer, String message) throws IOException {
        writer.write(message + "\n");
        writer.flush();
    }
    public static void outputFind(BufferedWriter writer, Person person, String message) throws IOException {
        writer.write(message + "\n");
        writer.write("이름: [" + person.getName() + "], 나이: [" + person.getAge() + "], 생일: [" + person.getBirthDate() + "]\n");
        writer.write("자기소개: [" + person.getIntro() + "]\n");
        writer.flush();
    }
    public static void outputUpdate(BufferedWriter writer, LocalDate birthDate, int age, String intro, Person updatedPerson, String message) throws IOException{
        writer.write(message + "\n");
        writer.write("이름: [" + updatedPerson.getName() + "], 나이: [" + age + "] -> [" + updatedPerson.getAge() +
                "], 생일: [" + birthDate + "] -> [" + updatedPerson.getBirthDate() + "]\n");
        writer.write("자기소개: [" + intro + "] -> [" + updatedPerson.getIntro() + "]\n");
    }
}
