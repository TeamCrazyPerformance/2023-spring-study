package org.example.domain;
import java.util.Arrays;
public enum DataBhvr {
    save(1),
    find(2),
    update(3),
    delete(4);
    private final int typeCode;
    DataBhvr(int typeCode) {
        this.typeCode = typeCode;
    }
    public static DataBhvr from(int typeCode) {
        return Arrays.stream(values())
                .filter(dataBhvr -> dataBhvr.typeCode == typeCode)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
