package org.example.view;

import java.util.List;

import org.example.domain.Histogram;

/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {
  public void printHist(Histogram histogram) {
    System.out.println("히스토그램 결과입니다.");
    histogram.drawHistogram();
  }
}
