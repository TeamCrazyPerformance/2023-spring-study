package org.example;

import org.example.dao.MyListDao;
import org.example.domain.Person;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Person> peopleList = new ArrayList<>();
        MyListDao listDao = new MyListDao(peopleList);
        boolean exitFlag = false;
        try {
            while(!exitFlag) {
                bw.write("접근할 데이터베이스 이름을 입력해주세요. (LIST, MAP)\n");
                bw.flush();
                String name = null;
                String databaseType = br.readLine();
                if (databaseType.equals("LIST")) {
                    bw.write("어떤 작업을 할 지 정해주세요. (SAVE: 1, FIND: 2, UPDATE: 3, DELETE: 4)\n");
                    bw.flush();
                    int operation = Integer.parseInt(br.readLine());
                    switch (operation) {
                        case 1:
                            OutputView.outputView(bw, "저장할 데이터를 입력해주세요.");
                            Person person = InputView.inputPerson(br);
                            listDao.save(person);
                            break;
                        case 2:
                            OutputView.outputView(bw, "조회할 이름를 입력해주세요.");
                            name = InputView.inputName(br);
                            Person foundPerson = listDao.find(name);
                            OutputView.outputFind(bw, foundPerson, "데이터 조회 결과입니다.");
                            break;
                        case 3:
                            OutputView.outputView(bw, "수정할 이름를 입력해주세요.");
                            name = InputView.inputName(br);
                            Person updatePerson = listDao.find(name);
                            LocalDate beforeDate = updatePerson.getBirthDate();
                            int beforeAge = updatePerson.getAge();
                            String beforeIntro = updatePerson.getIntro();
                            OutputView.outputView(bw, "수정할 데이터를 입력해주세요.");
                            Person updatedPerson = InputView.inputPerson(br, name);
                            listDao.update(updatePerson, updatedPerson);
                            OutputView.outputUpdate(bw, beforeDate, beforeAge, beforeIntro, updatedPerson, "데이터 수정 결과입니다.");
                            break;
                        case 4:
                            OutputView.outputView(bw, "삭제할 이름를 입력해주세요.");
                            name = InputView.inputName(br);
                            listDao.delete(name);
                            OutputView.outputView(bw, "데이터 삭제에 성공했습니다.");
                            break;
                        default:
                            OutputView.outputView(bw, "[ERROR] 잘못된 선택지입니다.");
                            continue;
                    }
                }

                if (databaseType.equals("MAP")) {
                    // 나중에 ㅠㅠㅠ...
                }
                OutputView.outputView(bw, "계속하시겠습니까? (CONTINUE: 0, EXIT: 1)");
                int exit = InputView.inputInteger(br);
                if (exit == 1)
                    exitFlag = true;
            }
        }catch(IllegalArgumentException e){
            OutputView.outputView(bw, e.getMessage());
        }finally {
            br.close();
            bw.close();
        }
    }
}