package org.example.domain;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
  private final List<DataInfo> histogram;

  public Histogram(List<DataInfo> histogram) {
    this.histogram = histogram;
  }

  public double sum() {
    double res = 0;
    for (DataInfo dataInfo: histogram) {
      res += dataInfo.getDataSize();
    }
    return res;
  }

  public double mean() {
    return sum() / histogram.size();
  }

  public void drawHistogram() {
    histogram.forEach((element) -> IntStream.rangeClosed(1, element.getDataSize()).forEach(i -> {
      if(i == 1) System.out.print(element.toString() + ": ");
      System.out.print("=");
      if(i == element.getDataSize()) System.out.println();
    }));
  }
}
