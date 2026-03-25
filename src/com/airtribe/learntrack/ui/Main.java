package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService
            = new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 ->
                        studentMenu();
                    case 2 ->
                        courseMenu();
                    case 3 ->
                        enrollmentMenu();
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default ->
                        System.out.println("Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // ---------------- STUDENT MENU ----------------
    private static void studentMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter batch: ");
                    String batch = scanner.nextLine();

                    studentService.addStudent(firstName, lastName, email, batch);
                }
                case 2 ->
                    studentService.listStudents();
                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    studentService.findStudentById(id);
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    studentService.deactivateStudent(id); // now works perfectly
                }
                default ->
                    System.out.println("Invalid option!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------------- COURSE MENU ----------------
    private static void courseMenu() {
        System.out.println("\n--- Course Menu ---");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Activate/Deactivate Course");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();

                    System.out.print("Enter duration (weeks): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    courseService.addCourse(name, desc, duration);
                }
                case 2 ->
                    courseService.listCourses();
                case 3 -> {
                    System.out.print("Enter course ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    courseService.toggleCourseStatus(id);
                }
                default ->
                    System.out.println("Invalid option!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ---------------- ENROLLMENT MENU ----------------
    private static void enrollmentMenu() {
        System.out.println("\n--- Enrollment Menu ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Student Enrollments");
        System.out.println("3. Update Enrollment Status");

        try {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(scanner.nextLine());

                    System.out.print("Course ID: ");
                    int cid = Integer.parseInt(scanner.nextLine());

                    enrollmentService.enrollStudent(sid, cid);
                }
                case 2 -> {
                    System.out.print("Student ID: ");
                    int sid = Integer.parseInt(scanner.nextLine());
                    enrollmentService.getEnrollmentsByStudent(sid);
                }
                case 3 -> {
                    System.out.print("Enrollment ID: ");
                    int eid = Integer.parseInt(scanner.nextLine());

                    System.out.print("Status (COMPLETED/CANCELLED): ");
                    String status = scanner.nextLine();

                    enrollmentService.updateStatus(eid, status);
                }
                default ->
                    System.out.println("Invalid option!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
