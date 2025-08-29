package com.acme;

public class Student {
    private String studentId;
    private String studentName;
    private Test studentTest;

    public Student() {}

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public Test getStudentTest() { return studentTest; }
    public void setStudentTest(Test studentTest) { this.studentTest = studentTest; }

    public void display() {
        System.out.println("Student Id   : " + studentId);
        System.out.println("Student Name : " + studentName);
        if (studentTest != null) {
            studentTest.display();
        }
    }
}
