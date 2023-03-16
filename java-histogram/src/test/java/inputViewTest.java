import org.example.view.InputView;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class inputViewTest {
    @Test
    void testInputString() throws IOException {
        // Arrange
        String input = "1, 2, 3, 4, five";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        // Act
        ArrayList<Integer> resultList = InputView.inputString(reader);
        // Assert
        assertThat(resultList).isEqualTo(expectedList);
    }

    @Test
    void testInputInteger() throws IOException {
        // Arrange
        String input = "5";
        BufferedReader reader = new BufferedReader(new StringReader(input));
        BufferedWriter writer = new BufferedWriter(new StringWriter());
        String message = "Enter the data count:";
        int expectedCount = 5;
        // Act
        int resultCount = InputView.inputInteger(reader, writer, message);
        // Assert
        assertThat(resultCount).isEqualTo(expectedCount);
    }
}
