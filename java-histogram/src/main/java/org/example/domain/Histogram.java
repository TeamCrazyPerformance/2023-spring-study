package org.example.domain;

import java.util.List;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {

    private static final String BAR_SYMBOL = "=";
    private static final String HISTOGRAM_BAR_FORMAT = "%s(%s): %s";

    private final List<DataInfo> dataInfoList;

    public Histogram(List<DataInfo> dataInfoList) {
        this.dataInfoList = dataInfoList;
    }

    public List<String> makeHistogram() {
        return dataInfoList.stream()
                .map(this::toHistogramBarWithDataInfo)
                .toList();
    }

    private String toHistogramBarWithDataInfo(DataInfo dataInfo) {
        return String.format(HISTOGRAM_BAR_FORMAT, dataInfo.getDataName(), dataInfo.getDataType(), makeHistogramBar(dataInfo.getDataSize()));
    }

    private String makeHistogramBar(int dataSize) {
        return BAR_SYMBOL.repeat(dataSize);
    }

    public double getAverage() {
        return dataInfoList.stream()
                .map(DataInfo::getDataSize)
                .mapToInt(dataSize -> dataSize)
                .average()
                .orElse(0);
    }
}
