package org.example.view;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * 입력을 담당하는 클래스
 */
public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static List<String> dataList = new ArrayList();
    public static int inputN(){
        System.out.println("데이터의 개수를 입력해주세요.");
        int n = sc.nextInt();
        return n;
    }
    public static void inputData(int n){
        System.out.println("각 데이터의 양을 입력해주세요.");
        for (int i=0; i < n; i++) {
            String data = sc.next();
            dataList.add(data);
        }
    }

}
