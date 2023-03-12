package org.example.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.domain.DataInfo;
import org.example.domain.Histogram;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {
  private BufferedReader br;

  public InputView() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int inputNByUser() throws IOException {
    int n = -1;
    System.out.println("데이터의 개수를 입력해주세요.");
    n = Integer.parseInt(br.readLine());
    if(n<0) throw new IOException("데이터의 개수는 음일 수 없습니다.");
    return n;
  }

  public Histogram inputHistByUser(int n) throws IOException {
    Histogram histogram;
    System.out.println("각 데이터의 양을 입력해주세요.");
    histogram = new Histogram(Stream.generate(()-> {
      try {
        return Integer.parseInt(br.readLine());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }).map(DataInfo::new).limit(n).collect(Collectors.toList()));
    return histogram;
  }

  public Histogram inputByUser() {
    try {
      return inputHistByUser(inputNByUser());
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
    return new Histogram(new ArrayList<>());
  }

}
