package org.example;

import org.example.domain.DataInfo;
import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.List;

public class HistogramController {

    private final InputView inputView;
    private final OutputView outputView;

    public HistogramController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        try {
            int numberOfData = inputView.getNumberOfData();
            List<DataInfo> dataInfoList = inputView.inputDataList(numberOfData);

            Histogram histogram = new Histogram(dataInfoList);

            outputView.printHistogram(histogram.makeHistogram());
            outputView.printAverage(histogram.getAverage());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
