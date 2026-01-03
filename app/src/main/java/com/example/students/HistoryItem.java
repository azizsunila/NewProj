package com.example.students;

public class HistoryItem {
    private String status;
    private String studentName;
    private String subject;
    private String time;

    public HistoryItem(String status, String studentName, String subject, String time) {
        this.status = status;
        this.studentName = studentName;
        this.subject = subject;
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }
}
