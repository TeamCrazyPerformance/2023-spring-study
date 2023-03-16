package org.example;

import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView.inputData(InputView.inputN());
        Histogram.makeHistogram();
        OutputView.histogramOutput();
        OutputView.avgOutput();
    }
}