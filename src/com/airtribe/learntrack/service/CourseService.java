package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    // ✅ Add Course (UPDATED)
    public void addCourse(String name, String description, int durationInWeeks) {

        Course course = new Course(name, description, durationInWeeks, true);
        courses.add(course);

        System.out.println("Course added successfully! ID: " + course.getId());
    }

    // ✅ View All Courses
    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(c); // uses your toString() 🔥
        }
    }

    // ✅ Find Course by ID
    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + id);
    }

    // ✅ Activate / Deactivate Course
    public void toggleCourseStatus(int id) {
        Course course = findCourseById(id);

        course.setActive(!course.isActive());

        System.out.println("Course status updated. Now Active: " + course.isActive());
    }

    // ✅ Optional helper
    public ArrayList<Course> getAllCourses() {
        return courses;
    }
}