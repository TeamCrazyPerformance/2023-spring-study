package org.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.example.domain.Histogram;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {
  private BufferedReader br;

  public InputView() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int inputNByUser() {
    int n = -1;
    try {
      System.out.println("데이터의 개수를 입력해주세요.");
      n = Integer.parseInt(br.readLine());
      if(n<0) throw new Exception("데이터의 개수는 음일 수 없습니.");
    } catch (Exception e) {
      System.out.println("[ERROR] " + e.getMessage());
      e.printStackTrace();
    }
    return n;
  }

  public List<Histogram> inputHistByUser(int n) {
    List<Histogram> hist = new ArrayList<Histogram>();
    try {
      System.out.println("각 데이터의 양을 입력해주세요.");
      while(n-- != 0) {
        hist.add(new Histogram(Integer.parseInt(br.readLine())));
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
    return hist;
  }

  public List<Histogram> inputByUser() {
    return inputHistByUser(inputNByUser());
  }

}
