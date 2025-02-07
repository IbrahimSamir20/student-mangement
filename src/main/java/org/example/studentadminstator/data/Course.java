package org.example.studentadminstator.data;

import java.util.ArrayList;

public class Course {
    private String name;
    private String attendant;
    private int grade;
    private Instructor instructor;
    private String instructorName;
    private ArrayList<Student> studentsAtCourse;

    public Course(String name, String attendant, int grade, Instructor instructor) {
        this.name = name;
        this.attendant = attendant;
        this.grade = grade;
        this.instructor = instructor;
        this.instructorName = instructor.getInstructorName();
        this.studentsAtCourse = new ArrayList<>();
    }

    public Course(String name, String attendant, int grade) {
        this.name = name;
        this.attendant = attendant;
        this.grade = grade;
        this.studentsAtCourse = new ArrayList<>();
    }

    public Course(String name, Instructor instructor) {
        this.name = name;
        this.instructor = instructor;
        this.instructorName = instructor.getInstructorName();
        this.studentsAtCourse = new ArrayList<>();
    }

    public Course(String name, String instructorName) {
        this.name = name;
        this.instructorName = instructorName;
        this.studentsAtCourse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttendant() {
        return attendant;
    }

    public void setAttendant(String attendant) {
        this.attendant = attendant;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.instructorName = instructor.getInstructorName();
    }

    public void addStudentToCourse(Student student) {
        if (student != null) {
            studentsAtCourse.add(student);
        }
    }

    public ArrayList<Student> getStudentsAtCourse() {
        return studentsAtCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", attendant='" + attendant + '\'' +
                ", grade=" + grade +
                ", instructor=" + (instructor != null ? instructor.getInstructorName() : "N/A") +
                ", studentsAtCourse=" + studentsAtCourse.size() +
                '}';
    }
}
