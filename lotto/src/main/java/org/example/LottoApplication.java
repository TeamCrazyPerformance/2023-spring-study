package org.example;

import java.util.Scanner;

import org.w3c.dom.css.CSS2Properties;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

// 추상화를 적절하게 사용한다. 라는 말이 무엇인지 모르겠습니다. 
// MVC 패턴과 도메인을 적절하게 사용하여 구현하라는 말이 무엇인지 모르겠습니다. 

public class LottoApplication {

    int [][] randomNumbers; 
    int[] winNumbers = new int[7];
    Integer paid; 

    static double value = 0; 

    public int getPaid() {
        Scanner input = new Scanner(System.in); 
        int paid; 
        while (true) {
            paid = input.nextInt(); 
            try {
                Exception e = new IllegalArgumentException();
                if (paid % 1000 != 0) throw e; 
                return paid;
            } catch (Exception e) {
                System.out.println("다시 입력 하세요: ");
            }
        }
    }

    public Boolean[] countBonus(int index) {
        Boolean[] bonus = new Boolean[index];
        int i = 0; 
        for (int [] list: randomNumbers) {
            if (Arrays.asList(list).contains(winNumbers[6]))
                bonus[i++] = true; 
        }
        return bonus;
    }

    public void createRandomNumbers(int paid) {
        randomNumbers = new int[paid/1000][6]; 
        int[] arr = new int[6]; 
        Random random = new Random(); 
        int flag; 
        for (int i = 0; i < paid/1000; i++) {
            for (int j = 0; j < 6; j++) {
                flag = 0; 
                int num = random.nextInt(45) + 1; 
                for (int k = 0; k < j; k++) {
                    if (num == arr[k]) {
                        j--; flag = 1;
                    }
                }
                if (flag == 1) continue;
                arr[j] = num; 
            }
            Arrays.sort(arr); 
            randomNumbers[i] = arr.clone();
        }
    }

    public void showRandomNumbers(int paid) {
        for (int i = 0; i < paid/1000; i++) {
            System.out.print("[");
            for (int j = 0; j < 6; j++) {
                System.out.print(Integer.toString(randomNumbers[i][j]));
                if (j != 5) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public void getWinNumbers() {
        Scanner input = new Scanner(System.in); 
        String[] winNumber = input.nextLine().split(","); 
        
        for (int i = 0; i < 6; i++) {
            try {
                Exception e = new IllegalArgumentException();
                if (Integer.parseInt(winNumber[i]) < 1 || Integer.parseInt(winNumber[i]) > 45 || winNumber.length != 6) {
                    throw e;
                }
            } catch (Exception e){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                winNumber = input.nextLine().split(","); 
                i = 0; continue; 
            }
            winNumbers[i] = Integer.parseInt(winNumber[i]); 
        }
    }

    public void getBonusNumber() {
        Scanner input = new Scanner(System.in); 
        int bonus;
        while (true) {
            try {
                Exception e = new IllegalArgumentException();
                bonus = input.nextInt(); 
                if (bonus < 1 || bonus > 45) throw e;
                break;
            } catch (Exception e) {
                System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        winNumbers[6] = bonus; 
    }

    public int[] howManyWins(int index) {
        int howMany; 
        int[] result = new int[index]; 
        int i = 0; 
        for (int[] list: randomNumbers) {
            howMany = 0; 
            for (int number: list) {
                for (int j = 0; j < 7; j++) {
                    if (winNumbers[j] == number) {
                        howMany++; 
                    }
                }
            }
            result[i++] = howMany; 
        }
        return result;
    }

    // enum 자료구조를 이런식으로 쓰는 것이 맞을까?
    enum Prize {
        FIRST_PRIZE("6개 일치 ("), 
        SECOND_PRIZE("5개 일치, 보너스 볼 일치 ("), 
        THIRD_PRIZE("5개 일치 ("), 
        FOURTH_PRIZE("4개 일치 ("), 
        FIFTH_PRIZE("3개 일치 ("),
        WON("원) -"),
        GAE("개\n");

        final private String name; 
        public String getName() {
            return name; 
        }
        private Prize(String name) {
            this.name = name; 
        }
    }

    public String[] moneyEachPrize(int kindLotto) {
        String[] money = new String[5];
        switch (kindLotto) {
            case 1: 
                money[Prize.FIRST_PRIZE.ordinal()] = "2,000,000"; money[Prize.SECOND_PRIZE.ordinal()] = "30,000";
                money[Prize.THIRD_PRIZE.ordinal()] = "1,500"; 
                money[Prize.FOURTH_PRIZE.ordinal()] = "500"; money[Prize.FIFTH_PRIZE.ordinal()] = "100"; 
                break;
            case 2: 
                money[Prize.FIRST_PRIZE.ordinal()] = "50,000,000"; money[Prize.SECOND_PRIZE.ordinal()] = "3,000,000"; 
                money[Prize.THIRD_PRIZE.ordinal()] = "150,000"; 
                money[Prize.FOURTH_PRIZE.ordinal()] = "50,000"; money[Prize.FIFTH_PRIZE.ordinal()] = "5,000"; 
                break;
            case 3:
                money[Prize.FIRST_PRIZE.ordinal()] = "2,147,000,000"; money[Prize.SECOND_PRIZE.ordinal()] = "850,000"; 
                money[Prize.THIRD_PRIZE.ordinal()] = "10,000"; 
                money[Prize.FOURTH_PRIZE.ordinal()] = "0"; money[Prize.FIFTH_PRIZE.ordinal()] = "0"; 
                break;
        }

        return money; 
    }
   
    public String toString(String[] moneyPrize, int[] result, Boolean[] hasBonus) {
        int first=0, second=0, third=0, fourth=0, fifth=0;
    
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 3) fifth++; 
            if (result[i] == 4) fourth++;
            if (result[i] == 5) {
                if (hasBonus[i] == true) second++;  
                else third++; 
            }
            if (result[i] == 6) first++;
        }

        value = first * Integer.parseInt(moneyPrize[Prize.FIRST_PRIZE.ordinal()].replace(",", ""))
        + second * Integer.parseInt(moneyPrize[Prize.SECOND_PRIZE.ordinal()].replace(",", ""))
        + third * Integer.parseInt(moneyPrize[Prize.THIRD_PRIZE.ordinal()].replace(",", ""))
        + fourth * Integer.parseInt(moneyPrize[Prize.FOURTH_PRIZE.ordinal()].replace(",", ""))
        + fifth * Integer.parseInt(moneyPrize[Prize.FIFTH_PRIZE.ordinal()].replace(",", ""));

        return Prize.FIFTH_PRIZE.name + moneyPrize[Prize.FIFTH_PRIZE.ordinal()] + Prize.WON.name + Integer.toString(fifth) + Prize.GAE.name
        + Prize.FOURTH_PRIZE.name + moneyPrize[Prize.FOURTH_PRIZE.ordinal()] + Prize.WON.name + Integer.toString(fourth) + Prize.GAE.name
        + Prize.THIRD_PRIZE.name + moneyPrize[Prize.THIRD_PRIZE.ordinal()] + Prize.WON.name + Integer.toString(third) + Prize.GAE.name
        + Prize.SECOND_PRIZE.name + moneyPrize[Prize.SECOND_PRIZE.ordinal()] + Prize.WON.name + Integer.toString(second) + Prize.GAE.name
        + Prize.FIRST_PRIZE.name + moneyPrize[Prize.FIRST_PRIZE.ordinal()] + Prize.WON.name + Integer.toString(first) + Prize.GAE.name;
    }
    
    // 구현할 기능
    // 1. 숫자를 랜덤 생성할 때 중복된 수들이 없어야 함.  ==> 해결됨. (더욱 멋진 코드로 바꾸는 작업이 필요할 듯)
    // 2. 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다. => 해결됨. 
    // ** 가능한 예외 상황:
    //  - 로또 번호를 1~45 사이의 정수가 아닌 수를 입력 받았을 때. ==> 해결됨. 
    //  - 낸 돈이 1000으로 나누어 떨어지지 않을 때. ==> 해결됨. 
    //  - 로또 종류 1~3 벗어날 때.
    //  - 받는 번호의 개수가 6이 아닐 떄.
    // 3. Java Enum을 적용한다. ==> 하긴 했는디.
    //  - Enum 자료구조에 대한 공부가 더 필요할 듯... 어떻게 사용해야 하지. 어떤 기능에 적용해야 할까?
    //  - 
    

    public static void main(String[] args) {   // main 함수에서 static 을 없애도 되나? 이걸 없애야 main 밖에 있는 변수들을 가져다 쓸 수 있는디. 
        
        java.util.Scanner input = new Scanner(System.in);
        LottoApplication lottoApplication = new LottoApplication(); 

        System.out.println("구입할 로또 종류를 선택해주세요. (작은 로또: 1, 중간 로또: 2, 큰 로또: 3)");
        int kindLotto = input.nextInt();

        System.out.println("구입금액을 입력해 주세요."); 
        int paid = lottoApplication.getPaid(); 

        System.out.println(Integer.toString(paid/1000) + "개를 구매했습니다.");
        lottoApplication.createRandomNumbers(paid);
        lottoApplication.showRandomNumbers(paid);
        input.nextLine(); 

        System.out.println("당첨 번호를 입력해 주세요.");
        lottoApplication.getWinNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        // winNumbers[6] = bonus;  // 이거 왜 안되는 거지?
        lottoApplication.getBonusNumber(); 

        int[] result = lottoApplication.howManyWins(paid/1000).clone();
        Boolean[] hasBonus = lottoApplication.countBonus(paid/1000).clone(); 
        String[] moneyPrize = lottoApplication.moneyEachPrize(kindLotto).clone(); 

        System.out.println("당첨 통계\n---");
        System.out.println(lottoApplication.toString(moneyPrize, result, hasBonus)); 

        double percentage = value / paid * 100; 
        System.out.println("총 수익률은 " + String.format("%.1f", percentage) + "%입니다. ");
    }
}