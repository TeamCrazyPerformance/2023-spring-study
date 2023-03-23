package org.example.view;

import org.example.domain.DataInfo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.example.common.ErrorMessage.INVALID_INPUT_DATA_INFO_FORMAT;
import static org.example.common.ErrorMessage.INVALID_NUMBER_OF_DATA;
import static org.example.common.ErrorMessage.NOT_INTEGER_VALUE;

/**
 * 입력을 담당하는 클래스
 */
public class InputView {

    private static final int DATA_INFO_LENGTH = 3;
    private static final String NUMBER_OF_DATA_SIZE_INPUT_MESSAGE = "데이터의 개수를 입력해주세요.";
    private static final String DATA_INFO_INPUT_MESSAGE = "각 데이터의 양을 입력해주세요.";

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getNumberOfData() {
        System.out.println(NUMBER_OF_DATA_SIZE_INPUT_MESSAGE);
        int numberOfData = convertToInt(scanner.nextLine());
        validateNumberOfData(numberOfData);
        return numberOfData;
    }

    private void validateNumberOfData(int numberOfData) {
        if (numberOfData < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_DATA);
        }
    }

    private int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_VALUE);
        }
    }

    public List<DataInfo> inputDataList(int numberOfData) {
        System.out.println(DATA_INFO_INPUT_MESSAGE);
        return Stream.generate(this::inputDataInfo)
                .limit(numberOfData)
                .toList();
    }

    private DataInfo inputDataInfo() {
        String[] dataInfoArray = scanner.nextLine().split(",");
        validateDataInfoFormat(dataInfoArray);

        String dataName = dataInfoArray[0];
        int dataSize = convertToInt(dataInfoArray[1]);
        int typeCode = convertToInt(dataInfoArray[2]);

        return DataInfo.from(dataName, dataSize, typeCode);
    }

    private void validateDataInfoFormat(String[] dataInfoArray) {
        if (dataInfoArray.length != DATA_INFO_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_DATA_INFO_FORMAT);
        }
    }
}
