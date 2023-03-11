package org.example.domain;

import java.util.ArrayList;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
    public ArrayList<String> drawing(ArrayList<Integer> numbers){
        ArrayList<String> histogram = new ArrayList<>();
        for(int num: numbers) {
            String eq = "";
            for (int i = 0; i < num; i++) {
                eq += "=";
            }
            histogram.add(eq);
        }
        return histogram;
    }
}
