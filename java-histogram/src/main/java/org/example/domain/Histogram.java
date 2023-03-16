package org.example.domain;

import java.util.ArrayList;
public class Histogram {
    public static String makeHistogram(int value) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value; i++) {
            sb.append("=");
        }
        return sb.toString();
    }
    public static String getAvg(ArrayList<Integer> data)
    {
        int sum = 0;
        for(int num: data)
            sum += num;
        double avg = (double)sum / data.size();
        avg = Math.round(avg * 10) / 10.0; // round to one decimal place
        return "" + avg;
    }

}
