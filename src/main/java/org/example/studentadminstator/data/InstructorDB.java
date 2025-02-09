package org.example.studentadminstator.data;

import java.util.ArrayList;

public class InstructorDB<I extends User> {

    private final ArrayList<Instructor> instructorDB = new ArrayList<>();

    public void createInstructor(Instructor instructor) {
        instructorDB.add(instructor);
    }

    public void delete(Instructor instructor) {
        instructorDB.removeIf(i -> i.getUsername().equals(instructor.getUsername()));
    }

    public ArrayList<Instructor> fetchInstructors() {
        return instructorDB;
    }

    public Instructor fetchOneInstructor(String username) {
        for (Instructor instructor : instructorDB) {
            if (instructor.getUsername().equals(username)) {
                return instructor;
            }
        }
        System.err.println("Instructor not found for username: " + username);
        return null;
    }

    public void updateInstructorWithoutIndex(Instructor instructor) {
        for (int i = 0; i < instructorDB.size(); i++) {
            if (instructorDB.get(i).getUsername().equals(instructor.getUsername())) {
                instructorDB.set(i, instructor);
                return;
            }
        }
        System.err.println("Instructor not found for update: " + instructor.getUsername());
    }

    public void printInstructors() {
        if (instructorDB.isEmpty()) {
            System.out.println("No instructors available.");
        } else {
            System.out.println("All Instructors:");
            for (Instructor instructor : instructorDB) {
                System.out.println(instructor);
            }
        }
    }
}
