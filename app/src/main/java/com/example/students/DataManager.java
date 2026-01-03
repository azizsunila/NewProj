package com.example.students;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private List<HistoryItem> historyList = new ArrayList<>();

    private DataManager() {
        // private constructor
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addHistoryItem(HistoryItem item) {
        historyList.add(0, item);
    }

    public List<HistoryItem> getHistoryList() {
        return historyList;
    }
}
