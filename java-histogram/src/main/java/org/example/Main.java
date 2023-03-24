package org.example;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView.inputData(InputView.inputN());
        OutputView.histogramOutput();
        OutputView.avgOutput();
    }
}