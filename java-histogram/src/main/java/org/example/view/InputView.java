package org.example.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {
    public static ArrayList<Integer> inputString(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] arr = line.split(",");
        ArrayList<Integer> list = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("-?\\d+");
        for (String s : arr) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                int num = Integer.parseInt(matcher.group());
                if(num < 0)
                    throw new IllegalArgumentException("[ERROR] 데이터의 양은 음수일 수 없습니다.");
                list.add(num);
            }
        }
        return list;
    }
    public static int inputInteger(BufferedReader reader, BufferedWriter writer, String message) throws IOException {
        OutputView outputview = new OutputView();
        outputview.outputView(writer, message);
        int dataCount = Integer.parseInt(reader.readLine());
        if (dataCount < 0)
            throw new IllegalArgumentException("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
        return dataCount;
    }
}
