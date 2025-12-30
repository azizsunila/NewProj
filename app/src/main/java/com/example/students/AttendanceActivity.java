package com.example.students;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        AutoCompleteTextView spinnerAttendance = findViewById(R.id.spinnerAttendance);
        String[] attendanceStatus = new String[] {"Present", "Absent"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, attendanceStatus);
        spinnerAttendance.setAdapter(adapter);

        spinnerAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerAttendance.showDropDown();
            }
        });

        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttendanceActivity.this, "Attendance marked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}