package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.StudentService;


public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        service.addStudent("Saurabh", "Lomte", "saurabh@gmail.com", "Java");
        service.addStudent(new Student("Rahul", "Patil", "rahul@gmail.com", "Python"));

        service.listStudents();

        // service.updateStudent(1000, "updated@gmail.com");

        // service.listStudents();
    }
}
