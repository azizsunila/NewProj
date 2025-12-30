package com.example.students;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {

    private List<Student> studentList;
    private StudentAdapter adapter;
    private TextView tvStudentCount, tvTotalStudents, tvPresentToday, tvAbsentToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        studentList = new ArrayList<>();
        studentList.add(new Student("Ayesha Khan", "BCS-001", "BSCS"));
        studentList.add(new Student("Zain Ahmed", "BIT-002", "BSIT"));
        studentList.add(new Student("Fatima Ali", "BSE-003", "BSSE"));

        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(studentList);
        rvStudents.setAdapter(adapter);

        tvStudentCount = findViewById(R.id.tvStudentCount);
        tvTotalStudents = findViewById(R.id.tvTotalStudents);
        tvPresentToday = findViewById(R.id.tvPresentToday);
        tvAbsentToday = findViewById(R.id.tvAbsentToday);

        updateStudentCounts();

        ExtendedFloatingActionButton fabAddStudent = findViewById(R.id.fabAddStudent);
        fabAddStudent.setOnClickListener(v -> showAddStudentDialog());
    }

    private void showAddStudentDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_student, null);
        builder.setView(dialogView);

        final EditText etStudentName = dialogView.findViewById(R.id.etStudentName);
        final EditText etRollNo = dialogView.findViewById(R.id.etRollNo);
        final EditText etClass = dialogView.findViewById(R.id.etClass);

        builder.setTitle("Add New Student")
                .setPositiveButton("Add", (dialog, which) -> {
                    String name = etStudentName.getText().toString();
                    String rollNo = etRollNo.getText().toString();
                    String className = etClass.getText().toString();

                    if (!name.isEmpty() && !rollNo.isEmpty() && !className.isEmpty()) {
                        studentList.add(new Student(name, rollNo, className));
                        adapter.notifyDataSetChanged();
                        updateStudentCounts();
                        Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }

    private void updateStudentCounts() {
        int totalStudents = studentList.size();
        // Dummy data for present and absent
        int presentStudents = (int) (totalStudents * 0.8);
        int absentStudents = totalStudents - presentStudents;

        tvStudentCount.setText(totalStudents + " Students");
        tvTotalStudents.setText(String.valueOf(totalStudents));
        tvPresentToday.setText(String.valueOf(presentStudents));
        tvAbsentToday.setText(String.valueOf(absentStudents));
    }
}