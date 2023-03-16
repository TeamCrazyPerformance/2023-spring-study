package org.example.domain;
import java.util.ArrayList;
import java.util.List;
import org.example.view.InputView;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
    static List<String> dataName = new ArrayList();
    static List<Integer> dataAmount = new ArrayList();
    static List<String> dataType = new ArrayList();
    public static List<String> dataName() {
        return dataName;
    }
    public static List<Integer> dataAmount() {
        return dataAmount;
    }
    public static List<String> dataType() {
        return dataType;
    }

    public static void makeHistogram(){
        for(int i=0; i < InputView.dataList.size();i++) {

            String[] dataSplit = InputView.dataList.get(i).split(",");
            dataName.add(dataSplit[0]);
            dataAmount.add(Integer.valueOf(dataSplit[1]));
            dataType.add(dataSplit[2]);
        }

    }
    public static double makeAverage(List<Integer> list){
        return list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }


}

