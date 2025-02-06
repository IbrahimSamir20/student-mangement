package org.example.studentadminstator.data;

import java.util.ArrayList;
import java.util.Arrays;

public class CoursesDB<T> {
       ArrayList<Course> coursesDB = new ArrayList<>();


        public void createCourse(Course course) {
                coursesDB.add(course);
        }

        public void updateCourseWithoutIndex(Course course, Course newCourse) {
            for (int i = 0; i < coursesDB.size(); i++) {
                if (coursesDB.get(i).getName().equals(course.getName())) {
                    coursesDB.set(i, newCourse);
                    return;
                }
            }
            System.err.println("Student not found for update: " + course.getName());
        }

        public void deleteCourseWithoutIndex(Course course) {
               for(int i=0; i< coursesDB.size(); i++){
                   if(coursesDB.get(i).getName().equals(course.getName())){
                       coursesDB.remove(course);
                   }
               }
        }

        public ArrayList<Course> fetch(){
                return coursesDB;
        }

        public Course fetchOnCourse(Course course){
            for(int i=0; i< coursesDB.size(); i++){
                if(coursesDB.get(i).getName().equals(course.getName())){
                    return course;
                }}
            return null;   //see
        }


        public Course fetchOnCourseForStudent(String studentName){
                Course oneCourseForStudent = null;
            for (Course course : coursesDB) {
                if (Arrays.stream(course.getStudents()).anyMatch(student -> student.getName().equals(studentName))) {
                    oneCourseForStudent = course;
                    break;
                }
            }
                return oneCourseForStudent;
        }

        public Course fetchOnCourseForInstructor(String instructorName){
                Course courseForInstructor = null;
                for(Course course : coursesDB){
                        if(course.getInstructor().getName().equals(instructorName)){
                                courseForInstructor = course;
                                break;
                        }
                }
                return courseForInstructor;
        }
        
}
