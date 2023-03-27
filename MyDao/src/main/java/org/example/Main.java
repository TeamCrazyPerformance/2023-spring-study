package org.example;

import org.example.dao.MyListDao;
import org.example.domain.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Person> peopleList = new ArrayList<>();
        MyListDao listDao = new MyListDao(peopleList);
        boolean exitFlag = false;
        while(!exitFlag) {
            bw.write("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)\n");
            bw.flush();
            String name = null;
            String databaseType = br.readLine();
            if (databaseType.equals("LIST")) {

                // 데이터베이스 작업 선택
                bw.write("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)\n");
                bw.flush();
                int operation = Integer.parseInt(br.readLine());
                switch (operation) {
                    case 1:
                        bw.write("저장할 데이터를 입력해주세요.\n");
                        bw.flush();
                        String[] personData = br.readLine().split(",");
                        name = personData[0];
                        LocalDate birthday = LocalDate.parse(personData[1], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                        String introduction = personData[2];
                        Person person = new Person(name, birthday, introduction);
                        peopleList.add(new Person(name, birthday, introduction));
                        listDao.save(person);
                        break;
                    case 2:
                        bw.write("조회할 이름를 입력해주세요.\n");
                        bw.flush();
                        name = br.readLine();
                        Person foundPerson = listDao.find(name);
                        if (foundPerson == null) {
                            bw.write("[ERROR] 해당 이름은 존재하지 않습니다.\n");
                            bw.flush();
                            continue;
                        }
                        bw.write("데이터 조회 결과입니다.\n");
                        bw.write("이름: [" + foundPerson.getName() + "], 나이: [" + foundPerson.getAge() + "], 생일: [" + foundPerson.getBirthDate() + "]\n");
                        bw.write("자기소개: [" + foundPerson.getIntro() + "]\n");
                        bw.flush();
                        break;
                    case 3:
                        bw.write("수정할 이름를 입력해주세요.\n");
                        bw.flush();
                        name = br.readLine();
                        Person updatePerson = listDao.find(name);
                        if (updatePerson == null) {
                            bw.write("[ERROR] 해당 이름은 존재하지 않습니다.\n");
                            bw.flush();
                            continue;
                        }
                        bw.write("수정할 데이터를 입력해주세요.\n");
                        bw.flush();
                        String[] updateData = br.readLine().split(",");
                        if(!name.equals(updateData[0]))
                        {
                            bw.write("[ERROR] 이름은 변경할 수 없습니다.\n");
                            bw.flush();
                            continue;
                        }
                        if (updateData.length != 3) {
                            bw.write("[ERROR] 입력 형식이 잘못되었습니다.\n");
                            continue;
                        }

                        Person updatedPerson = listDao.update(updateData[0], LocalDate.parse(updateData[1], DateTimeFormatter.ofPattern("yyyy.MM.dd")), updateData[2]);

                        if (updatedPerson == null)
                        {
                            bw.write("[ERROR] 데이터 수정에 실패했습니다.\n");
                            bw.flush();
                            continue;
                        }
                        bw.write("데이터 수정 결과입니다.\n");
                        bw.write("이름: [" + updatedPerson.getName() + "], 나이: [" + updatePerson.getAge() + "] -> [" + updatedPerson.getAge() +
                                    "], 생일: [" + updatePerson.getBirthDate() + "] -> [" + updatedPerson.getBirthDate() + "]\n");
                        bw.write("자기소개: [" + updatePerson.getIntro() + "] -> [" + updatedPerson.getIntro() + "]\n");
                        break;
                    case 4:
                        bw.write("삭제할 이름를 입력해주세요.\n");
                        bw.flush();
                        name = br.readLine();
                        boolean isDeleted = listDao.delete(name);
                        if (isDeleted) {
                            bw.write("데이터 삭제에 성공했습니다.\n");
                            bw.flush();
                            break;
                        } else {
                            bw.write("[ERROR] 데이터 삭제에 실패했습니다.\n");
                            bw.flush();
                            continue;
                        }
                    default:
                        bw.write("[ERROR] 잘못된 선택지입니다.\n");
                        bw.flush();
                        continue;
                }
            }

            if (databaseType.equals("MAP")) {
                // 나중에 ㅠㅠㅠ...
            }
            bw.write("계속하시겠습니까? (CONTINUE: 0, EXIT: 1)\n");
            bw.flush();
            String cont = br.readLine();
            int exit = Integer.parseInt(cont);
            if(exit == 1)
                exitFlag = true;
        }
        LocalDate localDate = LocalDate.of(1999, 4, 4);
        LocalDate localDate1 = LocalDate.now().minusYears(localDate.getYear());
        System.out.println("localDate1.getYear() = " + localDate1.getYear());
    }
}