package org.example;

import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            InputView inputView = new InputView();
            int n = inputView.receiveN();
            Histogram histogram = new Histogram();
            OutputView outputView = new OutputView();
            ArrayList<Integer> numbers = inputView.receiveA(n);
            ArrayList<String> his = histogram.drawing(numbers);
            outputView.print(his);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}