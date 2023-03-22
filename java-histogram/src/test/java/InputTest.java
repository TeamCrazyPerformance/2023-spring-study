import org.example.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InputTest {

    @Test
    public void testInputStringWithPositiveData() throws IOException {
        String input = "data1,10,20\n";
        BufferedReader reader = new BufferedReader(new StringReader(input));

        String[] result = InputView.inputString(reader);

        assertTrue(result.length == 3);
        assertTrue(result[0].equals("data1"));
        assertTrue(Integer.parseInt(result[1]) == 10);
        assertTrue(Integer.parseInt(result[2]) == 20);
    }

    @Test
    public void testInputStringWithNegativeData() throws IOException {
        String input = "data,-10,20\n";
        BufferedReader reader = new BufferedReader(new StringReader(input));

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () -> {
            InputView.inputString(reader);
        });

        assertTrue(thrownException.getMessage().equals("[ERROR] 데이터의 양은 음수일 수 없습니다."));
    }
}
