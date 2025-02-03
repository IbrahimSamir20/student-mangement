package org.example.studentadminstator.data;

public class Course {
        String name;
        String attendant;
        int grade;
        Instructor instructor;
        Student[] students;
        public Course (String name, String attendant,int grade, Instructor instructor,Student... students){
                
                this.name = name;
                this.attendant = attendant;
                this.grade = grade;
                this.students = students;
                this.instructor = instructor;

        }
}
