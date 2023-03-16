package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {

    @Test
    void sum() {
        //given
        List<DataInfo> dataInfoList = new ArrayList<>();
        dataInfoList.add(new DataInfo("데이터1,1,0"));
        dataInfoList.add(new DataInfo("데이터2,4,1"));
        dataInfoList.add(new DataInfo("데이터3,3,0"));
        Histogram histogram = new Histogram(dataInfoList);
        //when
        double sum = histogram.sum();
        //then
        assertEquals(8, sum);
    }

    @Test
    void mean() {
        //given
        List<DataInfo> dataInfoList = new ArrayList<>();
        dataInfoList.add(new DataInfo("데이터1,1,0"));
        dataInfoList.add(new DataInfo("데이터2,4,1"));
        dataInfoList.add(new DataInfo("데이터3,3,0"));
        Histogram histogram = new Histogram(dataInfoList);
        //when
        double mean = histogram.mean();
        //then
        assertEquals((double)8/3, mean);
    }
}