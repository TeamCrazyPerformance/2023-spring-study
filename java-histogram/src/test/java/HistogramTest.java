import java.util.ArrayList;

import org.example.domain.Histogram;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistogramTest {
    @Test
    public void testMakeHistogram() {
        String expectedOutput = "===";
        assertEquals(expectedOutput, Histogram.makeHistogram(3));
    }
    @Test
    public void testGetAvg() {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        testData.add(5);
        testData.add(10);
        testData.add(15);
        String expectedOutput = "10.0";
        assertEquals(expectedOutput, Histogram.getAvg(testData));
    }
}
