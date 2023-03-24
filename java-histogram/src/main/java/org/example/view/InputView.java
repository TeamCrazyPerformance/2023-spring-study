package org.example.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputView {
    public static String[] inputString(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] arr = line.split(",");
        if(Integer.parseInt(arr[1]) < 0 || Integer.parseInt(arr[2]) < 0)
            throw new IllegalArgumentException("[ERROR] 데이터의 양은 음수일 수 없습니다.");
        return arr;
    }
    public static int inputInteger(BufferedReader reader, BufferedWriter writer, String message) throws IOException {
        OutputView.outputView(writer, message);
        int dataCount = Integer.parseInt(reader.readLine());
        if (dataCount < 0)
            throw new IllegalArgumentException("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
        return dataCount;
    }
}
