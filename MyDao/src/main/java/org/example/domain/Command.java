package org.example.domain;

import java.util.Arrays;

public enum Command {
    CONTINUE(0), EXIT(1);

    private final int code;

    Command(int code) {
        this.code = code;
    }

    public static Command from(int code) {
        return Arrays.stream(Command.values())
                .filter(command -> command.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
