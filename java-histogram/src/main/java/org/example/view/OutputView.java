package org.example.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {
    public void print(ArrayList<String> histogram) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String str: histogram)
            bw.write(str + "\n");
        bw.flush();
    }
}
