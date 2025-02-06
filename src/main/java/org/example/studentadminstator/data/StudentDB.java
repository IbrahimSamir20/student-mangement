package org.example.studentadminstator.data;

import java.util.ArrayList;

public class StudentDB<S extends User> {

    private final ArrayList<Student> studentDB = new ArrayList<>();

    public void createStudent(Student student) {
        studentDB.add(student);
    }
    public void updateStudent(int index, Student student) {
        if (index >= 0 && index < studentDB.size()) {
            studentDB.set(index, student);
        } else {
            System.err.println("Invalid index: " + index);
        }
    }
    public void updateStudentWithoutIndex(Student student) {
        for (int i = 0; i < studentDB.size(); i++) {
            if (studentDB.get(i).getUsername().equals(student.getUsername())) {
                studentDB.set(i, student);
                return;
            }
        }
        System.err.println("Student not found for update: " + student.getUsername());
    }
    public void deleteStudent(Student student) {
        studentDB.removeIf(s -> s.getUsername().equals(student.getUsername()));
    }
    public ArrayList<Student> fetchStudents() {
        return studentDB;
    }
    public Student fetchOneStudentByName(String name) {
        for (Student student : studentDB) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        System.err.println("Student not found: " + name);
        return null;
    }
    public void printStudents() {
        if (studentDB.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("All Students:");
            for (Student student : studentDB) {
                System.out.println(student);
            }
        }
    }
}
