package org.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputView {
    public int receiveN() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 0)
            throw new IllegalArgumentException("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
        return n;
    }
    public ArrayList<Integer> receiveA(int n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num < 0)
                throw new IllegalArgumentException("[ERROR] 데이터의 양은 음수일 수 없습니다.");
            else {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
