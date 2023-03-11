package org.example.view;

import java.util.List;

import org.example.domain.Histogram;

/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {
  public void printHist(List<Histogram> hist) {
    System.out.println("히스토그램 결입니다.");
    for (Histogram e : hist) {
      for(int i=0; i<e.getData(); i++) {
        System.out.print("=");
      }
      System.out.println(); 
    }
  }
}
