package org.example.view;

import org.example.domain.DataType;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.IOException;
public class OutputView {

    public static void outputView(BufferedWriter writer, String message) throws IOException {
        writer.write(message);
        writer.write(" ");
        writer.newLine();
        writer.flush();
    }
    public static void outputView(BufferedWriter writer, String[] numbers, String dataType, String message) throws IOException {
        writer.write(numbers[0] + "(" + dataType + "): ");
        writer.write(message);
        writer.newLine();
    }
}
