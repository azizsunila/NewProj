package com.example.students;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        ExtendedFloatingActionButton fabAddStudent = findViewById(R.id.fabAddStudent);
        fabAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(StudentsActivity.this);
                dialog.setContentView(R.layout.dialog_add_student);
                dialog.show();
            }
        });
    }
}
