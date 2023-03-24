package org.example.view;
import org.example.domain.DataType;
import org.example.domain.Histogram;

/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {
    public static void histogramOutput(){
        System.out.println("히스토그램 결과입니다.");
        for (int i=0; i < Histogram.dataName().size();i++){
            System.out.print(Histogram.dataName().get(i));
            System.out.print("(TYPE_"+Histogram.dataType().get(i)+"): ");
            System.out.println("=".repeat(Histogram.dataAmount().get(i)));
        }
    }
    public static void avgOutput(){
        System.out.println("데이터 양에 대한 평균입니다.");
        System.out.print("평균: ");
        System.out.println(Histogram.makeAverage(Histogram.dataAmount()));
    }
}
