package com.example.students;

public class Student {
    private String name;
    private String rollNo;
    private String className;

    public Student(String name, String rollNo, String className) {
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getRollNo() + ", " + getClassName();
    }
}