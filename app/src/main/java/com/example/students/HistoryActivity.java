package com.example.students;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView rvHistory = findViewById(R.id.rvHistory);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));

        List<HistoryItem> historyItems = new ArrayList<>();
        historyItems.add(new HistoryItem("PRESENT", "Ayesha", "Android Development Lab", "10:30 AM • Today"));
        historyItems.add(new HistoryItem("ABSENT", "Amna", "Web Technology Theory", "09:15 AM • Today"));
        historyItems.add(new HistoryItem("PRESENT", "Fatima", "Computer Architecture Lab", "02:45 PM • Today"));
        historyItems.add(new HistoryItem("LATE", "Sakeena", "Data Structures & Algorithms", "09:05 AM • Today"));

        HistoryAdapter adapter = new HistoryAdapter(historyItems);
        rvHistory.setAdapter(adapter);
    }
}
