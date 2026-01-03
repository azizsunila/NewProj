package com.example.students;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity {

    private ArrayList<Student> studentList = new ArrayList<>();
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter(studentList);
        rvStudents.setAdapter(studentAdapter);

        ExtendedFloatingActionButton fabAddStudent = findViewById(R.id.fabAddStudent);
        fabAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddStudentDialog();
            }
        });
    }

    private void showAddStudentDialog() {
        Dialog dialog = new Dialog(StudentsActivity.this);
        dialog.setContentView(R.layout.dialog_add_student);

        EditText etStudentName = dialog.findViewById(R.id.etStudentName);
        EditText etRollNo = dialog.findViewById(R.id.etRollNo);
        EditText etClass = dialog.findViewById(R.id.etClass);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etStudentName.getText().toString();
                String rollNo = etRollNo.getText().toString();
                String className = etClass.getText().toString();

                if (!name.isEmpty() && !rollNo.isEmpty() && !className.isEmpty()) {
                    studentList.add(new Student(name, rollNo, className));
                    studentAdapter.notifyDataSetChanged();
                    Toast.makeText(StudentsActivity.this, "Student added successfully", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(StudentsActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
