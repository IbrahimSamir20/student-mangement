package org.example.studentadminstator.data;

import java.util.Arrays;

//TODO : عايزن نعمل معادلة بتضيف الطالب الواحد جوه المصفوفة
public class Course {
        private String name;
        private String attendant;
        private int grade;
        private Instructor instructor;
        private Student[] students;

        public Course (String name, String attendant,int grade, Instructor instructor,Student... students){
                
                this.name = name;
                this.attendant = attendant;
                this.grade = grade;
                this.students = students;
                this.instructor = instructor;

        }

        public Course (String name, String attendant,int grade){

                this.name = name;
                this.attendant = attendant;
                this.grade = grade;

        }
        public Course (String name, Instructor instructor){

                this.name = name;
                this.instructor = instructor;

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

        public void setInstructor(Instructor instructor) {
            this.instructor = instructor;
        }

        public Student[] getStudents() {
            return students;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }

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
