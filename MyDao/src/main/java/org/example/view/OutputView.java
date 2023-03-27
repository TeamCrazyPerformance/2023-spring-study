package org.example.view;

import org.example.controller.dto.UpdateResultDto;
import org.example.domain.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutputView {

    private static final String SAVE_RESULT_MESSAGE = "데이터 저장 결과입니다.";
    private static final String FIND_RESULT_MESSAGE = "데이터 조회 결과입니다.";
    private static final String UPDATE_RESULT_MESSAGE = "데이터 수정 결과입니다.";
    private static final String DELETE_RESULT_MESSAGE = "데이터가 삭제되었습니다.";
    private static final String PERSON_INFO_FORMAT = "이름: [%s], 나이: [%d], 생일: [%s]\n자기소개: [%s]";
    private static final String UPDATE_INFO_FORMAT = "이름: [%s] -> [%s], 나이: [%d] -> [%d], 생일: [%s] -> [%s]\n자기소개: [%s] -> [%s]";
    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String YYYY_MM_DD = "yyyy.MM.dd";


    public void printSaveResult(Person person) {
        System.out.println(SAVE_RESULT_MESSAGE);
        printPersonInfo(person);
    }

    public void printFindResult(Person person) {
        System.out.println(FIND_RESULT_MESSAGE);
        printPersonInfo(person);
    }

    private void printPersonInfo(Person person) {
        System.out.println(String.format(PERSON_INFO_FORMAT,
                person.getName(), person.getAge(),
                getFormattedBirthDay(person.getBirthDay()), person.getIntroduction()));
    }

    private String getFormattedBirthDay(LocalDate birthDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        return birthDay.format(formatter);
    }

    public void printUpdateResult(UpdateResultDto resultDto) {
        System.out.println(UPDATE_RESULT_MESSAGE);
        printUpdateInfo(resultDto.getPrevPerson(), resultDto.getUpdatePerson());
    }

    private void printUpdateInfo(Person prevPerson, Person updatePerson) {
        System.out.println(String.format(UPDATE_INFO_FORMAT,
                prevPerson.getName(), updatePerson.getName(),
                prevPerson.getAge(), updatePerson.getAge(),
                getFormattedBirthDay(prevPerson.getBirthDay()), getFormattedBirthDay(updatePerson.getBirthDay()),
                prevPerson.getIntroduction(), updatePerson.getIntroduction()));
    }

    public void printDeleteResult() {
        System.out.println(DELETE_RESULT_MESSAGE);
    }

    public void printError(String message) {
        System.out.println(String.format(ERROR_FORMAT, message));
    }
}
