package org.example.domain;

public enum Database {
    LIST, MAP;

    public static Database from(String name) {
        try {
            return Database.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
