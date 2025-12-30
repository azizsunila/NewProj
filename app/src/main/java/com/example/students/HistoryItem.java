package com.example.students;

public class HistoryItem {
    private String status;
    private String studentName;
    private String subject;
    private String timestamp;

    public HistoryItem(String status, String studentName, String subject, String timestamp) {
        this.status = status;
        this.studentName = studentName;
        this.subject = subject;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
    }
}
