package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Enrollment.Status;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    private StudentService studentService;
    private CourseService courseService;

    // Constructor Injection ✅
    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // ✅ Enroll Student in Course
    public void enrollStudent(int studentId, int courseId) {

        // Validate Student
        Student student = studentService.findStudentById(studentId);
        if (!student.isActive()) {
            System.out.println("Cannot enroll. Student is inactive.");
            return;
        }

        // Validate Course
        Course course = courseService.findCourseById(courseId);
        if (!course.isActive()) {
            System.out.println("Cannot enroll. Course is inactive.");
            return;
        }

        // Check duplicate enrollment 🔥 (important for marks)
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId &&
                e.getCourseId() == courseId &&
                e.getStatus() == Status.ACTIVE) {

                System.out.println("Student already enrolled in this course!");
                return;
            }
        }

        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollments.add(enrollment);

        System.out.println("Enrollment successful! ID: " + enrollment.getId());
    }

    // ✅ View Enrollments by Student
    public void getEnrollmentsByStudent(int studentId) {

        // Validate student exists
        studentService.findStudentById(studentId);

        boolean found = false;

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }

    // ✅ Update Enrollment Status
    public void updateStatus(int enrollmentId, String statusInput) {

        Enrollment enrollment = findEnrollmentById(enrollmentId);

        try {
            Status newStatus = Status.valueOf(statusInput.toUpperCase());
            enrollment.setStatus(newStatus);

            System.out.println("Enrollment status updated to " + newStatus);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status! Use: ACTIVE, COMPLETED, CANCELLED");
        }
    }

    // ✅ Find Enrollment by ID
    public Enrollment findEnrollmentById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with ID: " + id);
    }

    // ✅ Optional helper
    public ArrayList<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}