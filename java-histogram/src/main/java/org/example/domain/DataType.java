package org.example.domain;

import java.util.Arrays;

import static org.example.common.ErrorMessage.NO_SUCH_DATATYPE;

public enum DataType {
    TYPE_0(0),
    TYPE_1(1);

    private final int typeCode;

    DataType(int typeCode) {
        this.typeCode = typeCode;
    }

    public static DataType from(int typeCode) {
        return Arrays.stream(values())
                .filter(dataType -> dataType.typeCode == typeCode)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_DATATYPE));
    }
}
