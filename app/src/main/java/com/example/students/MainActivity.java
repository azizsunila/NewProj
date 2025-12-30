package com.example.students;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnAttendance = findViewById(R.id.btnAttendance);
        Button btnHistory = findViewById(R.id.btnHistory);
        Button btnMarkNowAndroidLab = findViewById(R.id.btnMarkNowAndroidLab);
        Button btnMarkNowAndroidTheory = findViewById(R.id.btnMarkNowAndroidTheory);
        Button btnMarkNowWebLab = findViewById(R.id.btnMarkNowWebLab);
        Button btnMarkNowWebTheory = findViewById(R.id.btnMarkNowWebTheory);
        Button btnMarkNowCALab = findViewById(R.id.btnMarkNowCALab);
        Button btnMarkNowCATheory = findViewById(R.id.btnMarkNowCATheory);
        Button btnMarkNowHCILab = findViewById(R.id.btnMarkNowHCILab);
        Button btnMarkNowHCITheory = findViewById(R.id.btnMarkNowHCITheory);
        Button btnMarkNowManagement = findViewById(R.id.btnMarkNowManagement);

        btnAttendance.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnMarkNowAndroidLab.setOnClickListener(this);
        btnMarkNowAndroidTheory.setOnClickListener(this);
        btnMarkNowWebLab.setOnClickListener(this);
        btnMarkNowWebTheory.setOnClickListener(this);
        btnMarkNowCALab.setOnClickListener(this);
        btnMarkNowCATheory.setOnClickListener(this);
        btnMarkNowHCILab.setOnClickListener(this);
        btnMarkNowHCITheory.setOnClickListener(this);
        btnMarkNowManagement.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int id = v.getId();
        if (id == R.id.btnAttendance || id == R.id.btnMarkNowAndroidLab || id == R.id.btnMarkNowAndroidTheory || id == R.id.btnMarkNowWebLab || id == R.id.btnMarkNowWebTheory || id == R.id.btnMarkNowCALab || id == R.id.btnMarkNowCATheory || id == R.id.btnMarkNowHCILab || id == R.id.btnMarkNowHCITheory || id == R.id.btnMarkNowManagement) {
            intent = new Intent(this, AttendanceActivity.class);
        } else if (id == R.id.btnHistory) {
            intent = new Intent(this, HistoryActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}