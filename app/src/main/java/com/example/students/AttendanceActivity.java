package com.example.students;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        EditText etStudentName = findViewById(R.id.etStudentName);
        EditText etClass = findViewById(R.id.etClass);
        AutoCompleteTextView spinnerAttendance = findViewById(R.id.spinnerAttendance);

        String[] attendanceStatus = new String[] {"Present", "Absent", "Late"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, attendanceStatus);
        spinnerAttendance.setAdapter(adapter);

        spinnerAttendance.setOnClickListener(v -> spinnerAttendance.showDropDown());

        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(v -> {
            String studentName = etStudentName.getText().toString();
            String subject = etClass.getText().toString();
            String status = spinnerAttendance.getText().toString();
            String time = new SimpleDateFormat("hh:mm a • EEE, MMM d", Locale.getDefault()).format(new Date());

            if (studentName.isEmpty() || subject.isEmpty() || status.isEmpty()) {
                Toast.makeText(AttendanceActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            HistoryItem newItem = new HistoryItem(status.toUpperCase(), studentName, subject, time);
            DataManager.getInstance().addHistoryItem(newItem);

            Toast.makeText(AttendanceActivity.this, "Attendance marked", Toast.LENGTH_SHORT).show();
            finish(); // Go back to the previous activity
        });
    }
}
