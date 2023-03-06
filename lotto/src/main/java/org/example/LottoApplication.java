package org.example;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class LottoApplication {
    public static int[][] Lotto(int count){
        Random random = new Random();
        int[][] array = new int[count][6];
        for(int i=0; i < count; i++){
            for(int j=0; j < 6; j++){
                array[i][j] = 1 + random.nextInt(45);
                for(int k=0; k < j; k++){
                    if(array[i][j] == array[i][k]){
                        j--;
                    }
                }
            }
            Arrays.sort(array[i]);
        }
        return array;
    }
    public static int match_number(int[] array, int[] correct_nums){
        int cnt = 0;
        for(int i=0; i< array.length;i++){
            for(int j=0; j< correct_nums.length;j++){
                if (array[i] == correct_nums[j]) cnt += 1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입할 로또 종류를 선택해주세요. (작은 로또: 1, 중간 로또: 2, 큰 로또: 3)");
        int num = sc.nextInt();

        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();

        int count = money/1000;
        System.out.println(count+"개를 구매했습니다.");
        int[][] array = Lotto(count);
        for(int i =0 ; i < count; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String input = sc.next();
        String[] correct_num = input.split(",");
        int[] correct_nums = Arrays.stream(correct_num).mapToInt(Integer::parseInt).toArray();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_num = sc.nextInt();
        int total_amount = 0;
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}