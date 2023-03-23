package org.example.domain;

import static org.example.common.ErrorMessage.INVALID_DATA_SIZE;

public class DataInfo {

    private final String dataName;
    private final int dataSize;
    private final DataType dataType;

    public DataInfo(String dataName, int dataSize, DataType dataType) {
        validateDataSize(dataSize);
        this.dataName = dataName;
        this.dataSize = dataSize;
        this.dataType = dataType;
    }

    private void validateDataSize(int dataSize) {
        if (dataSize < 0) {
            throw new IllegalArgumentException(INVALID_DATA_SIZE);
        }
    }

    public static DataInfo from(String dataName, int dataSize, int typeCode) {
        return new DataInfo(dataName, dataSize, DataType.from(typeCode));
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
