package org.example.domain;
import org.example.dao.MyListDao;

import java.util.Scanner;
public class InputView {
    private Scanner sc = new Scanner(System.in);
    public Person inputData(){
        System.out.println("저장할 데이터를 입력해주세요.");
        String[] data = sc.next().split(",");
        Person person = new Person(data[0], data[1], data[2]);
        return person;
    }
    public String inputDataType(){
        System.out.println("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)");
        String dataType = sc.nextLine();
        return dataType;
    }
    public int inputDataBhvr(){
        System.out.println("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)");
        int dataBhvr = sc.nextInt();
        return dataBhvr;
    }
    public String inputName(){
        System.out.println("조회할 이름을 입력해주세요.");
        String name = sc.nextLine();
        return name;
    }
    public int inputDecision(){
        System.out.println("계속하시겠습니까? (CONTINUE: 0, EXIT: 1)");
        int dc = sc.nextInt();
        return dc;
    }


}
