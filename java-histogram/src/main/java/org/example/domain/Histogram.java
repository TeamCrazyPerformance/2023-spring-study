package org.example.domain;
import java.util.ArrayList;
import java.util.List;


/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
    public static List<String> dataName = new ArrayList();
    public static List<Integer> dataAmount = new ArrayList();
    public static List<String> dataType = new ArrayList();
    public static List<String> dataName() {
        return dataName;
    }
    public static List<Integer> dataAmount() {
        return dataAmount;
    }
    public static List<String> dataType() {
        return dataType;
    }
    public static double makeAverage(List<Integer> list){
        return list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }


}

