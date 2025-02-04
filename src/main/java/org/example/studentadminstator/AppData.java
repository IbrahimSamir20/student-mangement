package org.example.studentadminstator;

import org.example.studentadminstator.data.*;

public class AppData {
    private static final AppData instance = new AppData();
    private final StudentDB<Student> studentDB;
    private final InstructorDB<Instructor> instructorDB;
    private final CoursesDB<Course> coursesDB;
    private final UsersDB<User> usersDB;

    private AppData() {
        studentDB = new StudentDB<>();
        instructorDB = new InstructorDB<>();
        coursesDB = new CoursesDB<>();
        usersDB = new UsersDB<>();
    }

    public static AppData getInstance() {
        return instance;
    }

    public StudentDB<Student> getStudentDB() {
        return studentDB;
    }

    public InstructorDB<Instructor> getInstructorDB() {
        return instructorDB;
    }

    public CoursesDB<Course> getCoursesDB() {
        return coursesDB;
    }

    public UsersDB<User> getUsersDB() {
        return usersDB;
    }

}