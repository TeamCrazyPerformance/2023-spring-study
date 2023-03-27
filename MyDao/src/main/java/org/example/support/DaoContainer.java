package org.example.support;

import org.example.dao.MyDao;
import org.example.dao.MyListDao;
import org.example.dao.MyMapDao;
import org.example.domain.Database;

public class DaoContainer {

    private final MyDao listDao;
    private final MyDao mapDao;

    public DaoContainer() {
        this.listDao = new MyListDao();
        this.mapDao = new MyMapDao();
    }

    public MyDao getDaoFromDatabase(Database database) {
        switch (database) {
            case LIST -> {
                return listDao;
            }
            case MAP -> {
                return mapDao;
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
