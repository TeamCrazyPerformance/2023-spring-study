package org.example;

import java.util.List;

import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Main {
  public static void main(String[] args) {
    Histogram histogram;
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();

    histogram = inputView.inputByUser();
    outputView.printHist(histogram);
  }
}
