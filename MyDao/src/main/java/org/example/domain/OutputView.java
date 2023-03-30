package org.example.domain;

public class OutputView {
    private static final String result = "이름: [%s] 나이: [%s] 생일: [%s] \n자기소개: [%s]";
    private static final String updateResult = "이름: [%s] 나이: [%s] -> [%s] 생일: [%s] -> [%s] \n자기소개: [%s] -> [%s]";
    public void dataStatus(Person person){
        System.out.println(String.format(result, person.getName(), person.getAge(), person.getBirth(), person.getMe()));
    }
    public void outputSave(Person person){
        System.out.println("데이터 저장 결과입니다.");
        dataStatus(person);
    }
    public void outputSearch(Person person){
        System.out.println("데이터 조회 결과입니다.");
        dataStatus(person);
    }
    public void outputUpdate(Person person, String updateBirth, String updateMe){
        System.out.println("데이터 수정 결과입니다.");
        System.out.println(String.format(updateResult, person.getName(), person.getAge(), person.getBirth(), updateBirth, person.getMe(), updateMe, "1"));
    }
    public void outputError(){
        System.out.println("[ERROR] 해당 이름은 존재하지 않습니다.");
    }
}
