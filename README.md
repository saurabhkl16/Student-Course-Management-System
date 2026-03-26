# 📚 LearnTrack - Student Management System
## 🚀 Overview

* LearnTrack is a simple Java-based Student Management System.
* That allows users to manage students and courses efficiently. 
* It supports adding, updating, deleting, and can see list of student data.

=====================================================================================

## 🛠️ Features

* Add new students
* Update student details
* Deactivate students
* View all students
* Unique ID generation using static methods
* Clean layered architecture (Entity, Service, Utility)

=====================================================================================

## 🏗️ Project Structure

```
com/airtribe/learntrack/
│
├── constant/
│   ├── AppConstants.java
│   └── MenuOptions.java
│
├── entity/
│   └── Student.java
│
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
│
├── util/
│   └── IdGenerator.java
│
└── ui/
    └── Main.java

```

---

## 🧠 Class Diagram

```
+-------------------+
|     Student       |
+-------------------+
| - id: int         |
| - name: String    |
| - isActive: bool  |
+-------------------+
| + getters/setters |
+-------------------+

          ▲
          |
          |

+-------------------------+
|    StudentService       |
+-------------------------+
| - students: List        |
+-------------------------+
| + addStudent()          |
| + updateStudent()       |
| + deactivateStudent()   |
| + listStudents()        |
+-------------------------+

          ▲
          |
          |

+-------------------------+
|     IdGenerator         |
+-------------------------+
| - static counter        |
+-------------------------+
| + getNextStudentId()    |
+-------------------------+

          ▲
          |
          |

+-------------------------+
|         Main            |
+-------------------------+
| + main()               |
+-------------------------+
```

---

## ⚙️ How to Run

1. Compile all files:

```
javac com/airtribe/learntrack/**/*.java
```

2. Run the application:

```
java com.airtribe.learntrack.main
```

---

## 📌 Technologies Used

* Java (Core)
* OOP Concepts (Encapsulation, Abstraction)
* Collections (List)

---

===========================

## 👨‍💻 Author
Saurabh Lomte

===========================
