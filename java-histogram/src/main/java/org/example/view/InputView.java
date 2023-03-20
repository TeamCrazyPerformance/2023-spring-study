package org.example.view;
import org.example.domain.Histogram;
import java.util.Scanner;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static int inputN(){
        System.out.println("데이터의 개수를 입력해주세요.");
        int n = sc.nextInt();
        if (n < 0) {
            throw new IllegalArgumentException("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
        } return n;
    }
    public static void inputData(int n) {
        System.out.println("각 데이터의 양을 입력해주세요.");
        for (int i=0; i < n; i++) {
            String data = sc.next();
            String[] dataSplit = data.split(",");
            Histogram.dataName.add(dataSplit[0]);
            if (Integer.valueOf(dataSplit[1]) < 0) {
                throw new IllegalArgumentException("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
            }
            Histogram.dataAmount.add(Integer.valueOf(dataSplit[1]));
            Histogram.dataType.add(dataSplit[2]);
        }
    }

}
