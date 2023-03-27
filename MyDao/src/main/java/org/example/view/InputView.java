package org.example.view;

import org.example.controller.dto.PersonCreateDto;
import org.example.controller.dto.PersonUpdateDto;
import org.example.domain.Command;
import org.example.domain.Query;
import org.example.domain.Database;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Database inputDatabase() {
        String databaseName = scanner.nextLine();
        return Database.from(databaseName);
    }

    public Query inputQuery() {
        int code = convertToInt(scanner.nextLine());
        return Query.from(code);
    }

    private int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public PersonCreateDto inputCreateData() {
        //입력 로직
        return null;
    }

    public String inputFindName() {
        //입력 로직
        return null;
    }

    public PersonUpdateDto inputUpdateData() {
        //입력 로직
        return null;
    }

    public Command inputCommand() {
        //입력 로직
        return null;
    }
}
