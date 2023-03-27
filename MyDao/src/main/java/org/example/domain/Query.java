package org.example.domain;

import java.util.Arrays;

public enum Query {
    SAVE(1),
    FIND(2),
    UPDATE(3),
    DELETE(4);

    private final int code;

    Query(int code) {
        this.code = code;
    }

    public static Query from(int code) {
        return Arrays.stream(Query.values())
                .filter(database -> database.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
