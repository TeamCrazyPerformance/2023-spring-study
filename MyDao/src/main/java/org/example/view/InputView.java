package org.example.view;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public String inputDBName() {
    System.out.println("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)");
    String DBName = scanner.nextLine();
    return DBName;
  }

  public int inputCommand() {
    System.out.println("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)");
    int command = Integer.parseInt(scanner.nextLine());
    return command;
  }

  public String[] inputNewPerson() {
    System.out.println("저장할 데이터를 입력해주세요.");
    String[] tokens = scanner.nextLine().split(",");
    return tokens;
  }

  public String inputFind() {
    System.out.println("조회할 이름를 입력해주세요.");
    String name = scanner.nextLine();
    return name;
  }

  public String inputUpdate() {
    System.out.println("수정할 이름를 입력해주세요.");
    String name = scanner.nextLine();
    return name;
  }

  public String[] inputUpdatePerson(String name) {
    System.out.println("수정할 데이터를 입력해주세요.");
    System.out.println(name);
    String[] tokens = scanner.nextLine().split(",");
    return tokens;
  }

  public int isContinue() {
    System.out.println("계속하시겠습니까? (CONTINUE: 0, EXIT: 1)");
    int command = Integer.parseInt(scanner.nextLine());
    return command;
  }

  public String deletePerson() {
    System.out.println("삭제할 이름을 입력해주세요.");
    String name = scanner.nextLine();
    return name;
  }
}
