package org.example.studentadminstator.data;

import java.util.ArrayList;

public class CoursesDB<T> {
//        private Course course;
       ArrayList<Course> coursesDB = new ArrayList<>();

//        public CoursesDB(Course course) {
//                this.course = course;
//        }

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

        
}
