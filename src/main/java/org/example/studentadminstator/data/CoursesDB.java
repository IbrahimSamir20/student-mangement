package org.example.studentadminstator.data;

import java.util.ArrayList;
import java.util.Arrays;

public class CoursesDB<T> {
       ArrayList<Course> coursesDB = new ArrayList<>();

        public void createCourse(Course course) {
                coursesDB.add(course);
        }

        public void updateCourse(Course newCourse, int index) {
                coursesDB.set(index, newCourse);
        }

        public void deleteCourse(int index) {
                coursesDB.remove(index);
        }

        public ArrayList<Course> fetch(){
                return coursesDB;
        }

        public Course fetchOnCourse(int index){
               return coursesDB.get(index);
        }

        public int getIndex(String courseName){
               int courseIndex = -1;
                for(Course course: coursesDB){
                        if(course.getName().equals(courseName)){
                                return coursesDB.indexOf(course);
                        }
                }
                return courseIndex;
        }

        public Course fetchOnCourseForStudent(String studentName){
                Course oneCourseForStudent = null;
                for(int i = 0; i < coursesDB.size(); i++){
                        Course course = coursesDB.get(i);
                        if(Arrays.stream(course.getStudents()).anyMatch(student -> student.getName().equals(studentName))){
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
