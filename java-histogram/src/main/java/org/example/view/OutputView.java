package org.example.view;

import java.util.List;

/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {

    private static final String ERROR_FORMAT = "[ERROR] %s";
    private static final String AVERAGE_OUTPUT_MESSAGE = "데이터 양에 대한 평균입니다.";
    private static final String AVERAGE_FORMAT = "평균: %f";

    public void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_FORMAT, errorMessage));
    }

    public void printHistogram(List<String> histogramGraph) {
        histogramGraph.forEach(System.out::println);
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printAverage(double average) {
        System.out.println(AVERAGE_OUTPUT_MESSAGE);
        System.out.println(String.format(AVERAGE_FORMAT, average));
    }
}
