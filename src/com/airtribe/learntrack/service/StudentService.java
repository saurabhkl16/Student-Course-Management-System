package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully");
    }

    // Method Overloading (important 🔥)
    public void addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(firstName, lastName, email, batch);
        students.add(student);
        System.out.println("Student added using overloaded method");
    }

    // Remove student by ID
    public void removeStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    // Update student email
    public void updateStudent(int id, String newEmail) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setEmail(newEmail);
                System.out.println("Student updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    // List all students
    public void listStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    public void deactivateStudent(int id) {
        // Find student by ID
        Student student = findStudentById(id); // we just added this method

        // Set active = false
        student.setActive(false);

        System.out.println("Student deactivated successfully: " + student.getDisplayName());
    }
}
