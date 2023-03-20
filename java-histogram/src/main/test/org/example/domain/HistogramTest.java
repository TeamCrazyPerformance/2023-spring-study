package org.example.domain;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {
    @Test
    public void makeAverageTest(){
        Histogram histogram = new Histogram();
        List<Integer> dataAmount = new ArrayList<>();
        dataAmount.add(0);
        dataAmount.add(1);
        dataAmount.add(1);
        dataAmount.add(0);
        dataAmount.add(1);
        assertEquals(3.2, histogram.makeAverage(dataAmount));
    }
    
}