package com.airtribe.learntrack.entity;

import java.time.LocalDate;
import com.airtribe.learntrack.util.IdGenerator;

public class Enrollment {
    public enum Status { ACTIVE, COMPLETED, CANCELLED } // optional enum

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private Status status;

    // Default constructor
    public Enrollment() {
        this.id = IdGenerator.generateId();
        this.enrollmentDate = LocalDate.now();
        this.status = Status.ACTIVE;
    }

    // Parameterized constructor
    public Enrollment(int studentId, int courseId, LocalDate enrollmentDate, Status status) {
        this.id = IdGenerator.generateId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    // Constructor overloading: default date = today, status = ACTIVE
    public Enrollment(int studentId, int courseId) {
        this(studentId, courseId, LocalDate.now(), Status.ACTIVE);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                '}';
    }
}