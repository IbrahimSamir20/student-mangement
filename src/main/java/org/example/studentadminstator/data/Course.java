package org.example.studentadminstator.data;

import java.util.Arrays;

public class Course {
        private String name;
        private String attendant;
        private int grade;
        private Instructor instructor;
        private Student[] students;
        //Course Data Structure
        public Course (String name, String attendant,int grade, Instructor instructor,Student... students){
                
                this.name = name;
                this.attendant = attendant;
                this.grade = grade;
                this.students = students;
                this.instructor = instructor;

        }
        //Student Table View Data Structure
        public Course (String name, String attendant,int grade){

                this.name = name;
                this.attendant = attendant;
                this.grade = grade;

        }
        public Course (String name, Instructor instructor){

                this.name = name;
                this.instructor = instructor;

        }
        
        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name
        public void setName(String name) {
            this.name = name;
        }

        // Getter for attendant
        public String getAttendant() {
            return attendant;
        }

        // Setter for attendant
        public void setAttendant(String attendant) {
            this.attendant = attendant;
        }

        // Getter for grade
        public int getGrade() {
            return grade;
        }


        // Setter for grade
        public void setGrade(int grade) {
            this.grade = grade;
        }

        // Getter for instructor
        public Instructor getInstructor() {
            return instructor;
        }

        // Setter for instructor
        public void setInstructor(Instructor instructor) {
            this.instructor = instructor;
        }

        // Getter for students
        public Student[] getStudents() {
            return students;
        }

        // Setter for students
        public void setStudents(Student[] students) {
            this.students = students;
        }

        // toString method
        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    ", attendant='" + attendant + '\'' +
                    ", grade=" + grade +
                    ", instructor=" + instructor +
                    ", students=" + Arrays.toString(students) +
                    '}';
        }
}
