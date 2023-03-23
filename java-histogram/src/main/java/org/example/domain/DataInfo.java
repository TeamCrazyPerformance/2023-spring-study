package org.example.domain;

import static org.example.common.ErrorMessage.INVALID_DATA_SIZE;

public class DataInfo {

    private final String dataName;
    private final DataType dataType;
    private final int dataSize;

    public DataInfo(String dataName, DataType dataType, int dataSize) {
        validateDataSize(dataSize);
        this.dataName = dataName;
        this.dataType = dataType;
        this.dataSize = dataSize;
    }

    private void validateDataSize(int dataSize) {
        if (dataSize < 0) {
            throw new IllegalArgumentException(INVALID_DATA_SIZE);
        }
    }

    public static DataInfo from(String dataName, int typeCode, int dataSize) {
        return new DataInfo(dataName, DataType.from(typeCode), dataSize);
    }

    public String getDataName() {
        return dataName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public int getDataSize() {
        return dataSize;
    }
}
