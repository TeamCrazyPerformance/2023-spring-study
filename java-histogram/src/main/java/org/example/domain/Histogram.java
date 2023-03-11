package org.example.domain;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
  private int data;

  public Histogram(int data) {
    this.data = data;
  }

  public int getData() {return data;}

  public void setData(int data) {
    this.data = data;
  }
}
