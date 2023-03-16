package org.example;

import org.example.domain.DataType;
import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static final String INPUT_MESSAGE = "데이터의 개수를 입력해주세요.";
    private static final String DATA_MESSAGE = "각 데이터의 양을 입력해주세요.";
    private static final String AVG_MESSAGE = "데이터 양에 대한 평균입니다.";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        InputView inputview = new InputView();
        OutputView outputview = new OutputView();
        Histogram hist = new Histogram();
        try {
            int dataCount = inputview.inputInteger(reader, writer, INPUT_MESSAGE);
            outputview.outputView(writer, DATA_MESSAGE);
            writer.newLine();
            ArrayList<Integer> amount = new ArrayList<>();
            for (int i = 0; i < dataCount; i++) {
                ArrayList<Integer> data = inputview.inputString(reader);
                amount.add(data.get(1));
                String histogram = hist.makeHistogram(data.get(1));
                if (data.get(2) == 0)
                    outputview.outputView(writer, data.get(0), DataType.TYPE_0.name(), histogram);
                else
                    outputview.outputView(writer, data.get(0), DataType.TYPE_1.name(), histogram);
            }
            outputview.outputView(writer, AVG_MESSAGE);
            outputview.outputView(writer, "평균: " + hist.getAvg(amount));
            writer.flush();
        }catch (IllegalArgumentException e) {
            outputview.outputView(writer, e.getMessage());
        }finally {
            reader.close();
            writer.close();
        }
    }
}